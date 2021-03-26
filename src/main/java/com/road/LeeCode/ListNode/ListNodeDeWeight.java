package com.road.LeeCode.ListNode;

import io.swagger.models.auth.In;

import java.util.*;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class ListNodeDeWeight {

    /**
     * 思路与算法
     * <p>
     * 由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，因此我们只需要对链表进行一次遍历，就可以删除重复的元素。
     * <p>
     * 由于链表的头节点可能会被删除，因此我们需要额外使用一个哑节点（dummy node）指向链表的头节点。
     * <p>
     * 具体地，我们从指针cur指向链表的哑节点，随后开始对链表进行遍历。如果当前cur.next与cur.next.next对应的元素相同，
     * 那么我们就需要将cur.next以及所有后面拥有相同元素值的链表节点全部删除。
     * <p>
     * 我们记下这个元素值 xx，随后不断将cur.next 从链表中移除，直到cur.next 为空节点或者其元素值不等于 xx 为止。
     * <p>
     * 此时，我们将链表中所有元素值为 xx 的节点全部删除。
     * <p>
     * 如果当前cur.next与cur.next.next对应的元素不相同，那么说明链表中只有一个元素值为cur.next 的节点，那么我们就可以将cur指向cur.next。
     * <p>
     * 当遍历完整个链表之后，我们返回链表的的哑节点的下一个节点dummy.next 即可。
     * <p>
     * 需要注意cur.next 以及cur.next.next 可能为空节点，如果不加以判断，可能会产生运行错误。
     *
     * @param listNode
     * @return
     */
    public ListNode finalDeleteDuplicates(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }

        // 哑节点
        ListNode dummy = new ListNode(0, listNode);

        // cur指向链表的哑节点
        ListNode curr = dummy;
        // 对链表进行遍历
        while (curr.next != null && curr.next.next != null) {
            // 如果当前cur.next与cur.next.next对应的元素相同
            if (curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                // 相同元素遍历并重新赋值
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return dummy;
    }

    /**
     * 重复元素不删除
     *
     * @param listNode
     * @return
     */
    public ListNode notDeleteDuplicates(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }

        ListNode curr = listNode;
        while (listNode.next != null) {
            // 若第一个节点值与第二个节点值相等，第一个节点的next直接指向第三个节点
            if (curr.val == curr.next.val) {
                // 第三个节点赋值给第二个节点（第一个节点直接指向第三个节点）
                curr.next = curr.next.next;
            } else {
                // 重新赋值当前节点
                curr = curr.next;
            }
        }
        return listNode;
    }

    /**
     * two upgrade 优化
     *
     * @param listNode
     * @return
     */
    public ListNode deleteDuplicatesTwo(ListNode listNode) {
        if (listNode == null || listNode.next == null)
            return listNode;

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>(16);
        for (int i = 0; listNode != null; i++) {
            if (linkedHashMap.containsKey(listNode.val)) {
                linkedHashMap.put(listNode.val, linkedHashMap.get(listNode.val) + 1);
            } else {
                linkedHashMap.put(listNode.val, 1);
            }
            listNode = listNode.next;
        }

        ListNode newListNode, head = null, tail = null;
        for (Integer integer : linkedHashMap.keySet()) {
            if (linkedHashMap.get(integer) == 1) {
                newListNode = new ListNode();
                newListNode.val = integer;
                if (head == null) {
                    head = tail = newListNode;
                } else {
                    tail.next = newListNode;
                    tail = newListNode;
                }
            }
        }
        System.out.println("head" + head);
        return head;
    }

    /**
     * 第一次去除重复元素
     *
     * @param listNode
     * @return
     */
    public ListNode deleteDuplicatesOne(ListNode listNode) {
        // 若空返回
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        // 初始化HashMap
        HashMap<Integer, Integer> hashMap = new HashMap(16);
        // 将链表遍历，push到HashMap中，HashMap中value计数重复的元素个数
        int n;
        for (n = 0; listNode != null; n++) {
            if (hashMap.containsKey(listNode.val)) {
                hashMap.put(listNode.val, hashMap.get(listNode.val) + 1);
            } else {
                hashMap.put(listNode.val, 1);
            }
            listNode = listNode.next;
        }

        // 遍历HashMap转Array
        ArrayList<Integer> arrayList = new ArrayList();
        for (Integer i : hashMap.keySet()) {
            if (hashMap.get(i) == 1) {
                arrayList.add(i);
            }
        }

        // Array大小排序
        Collections.sort(arrayList);

        //遍历长度为arrayList.size
        ListNode newListNode, head = null, tail = null;
        for (Integer i : arrayList) {
            newListNode = new ListNode();
            newListNode.val = i;
            if (head == null) {
                head = tail = newListNode;
            } else {
                // 新节点接入节点尾部
                tail.next = newListNode;
                // tail永远是最后一个节点
                tail = newListNode;
            }
        }

        System.out.println("head" + head);
        return head;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(6);
        arrayList.add(7);
        // Array转ListNode
        ListNode newListNode, head = null, tail = null;
        for (Integer i : arrayList) {
            newListNode = new ListNode();
            newListNode.val = i;
            if (head == null) {
                head = tail = newListNode;
            } else {
                // 将新节点连接到尾部
                tail.next = newListNode;
                // tail永远是最后一个节点
                tail = newListNode;
            }
        }
        System.out.println("finalList" + head);
        new ListNodeDeWeight().deleteDuplicatesTwo(head);
    }
}
