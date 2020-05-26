package com.road.LeeCode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入: [   1->4->5,   1->3->4,   2->6 ] 输出: 1->1->2->3->4->4->5->6
 *
 * @author Jack Road
 */
public class ListNodeMergeNSortLists {

    /**
     * 解决方法一
     *
     * 思路
     * 
     * 两两合并，先从第一个与第二个合并，合并之后再与第三个合并
     * 
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 判断是否为null
        if (lists == null || lists.length < 1) {
            return null;
        }

        /**
         * 将lists[0]作为最终合并的链表，然后将list[0]和lists[1]合并成lists[0-1]
         *
         * 再将lists[0-1]和lists[2]合并，如此反复最终lists[0]就是最终结果
         *
         */
        // 获取第一个ListNode中的数据
        ListNode listNode = lists[0];
        // 从第二个ListNode开始遍历
        for (int i = 1; i < lists.length; i++) {
            listNode = mergeTwoListNode(listNode, lists[i]);
        }
        return listNode;
    }

    /**
     * 解决方法二
     *
     * 思路
     *
     * 创建一个堆
     *
     * 遍历链表数组，然后将每个链表的每个节点都放入堆中
     *
     * 从堆中不断取出元素，并将取出的元素串联起来
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        // 判断是否为null
        if (lists == null || lists.length < 1) {
            return null;
        }
        // 创建一个堆，并设置元素的排序方式
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        // 遍历链表数组，然后将每个链表的每个节点都放入堆中
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        // 从堆中不断取出元素，并将取出的元素串联起来
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!queue.isEmpty()) {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;
    }

    /**
     * 解决方法三
     * 
     * 思路
     *
     * 先将ListNode数组拆分中2部分，即二分法+递归的方式
     * 
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length);
    }

    public ListNode mergeLists(ListNode[] lists, int start, int end) {
        int count = end - start;
        if (count == 0) {
            return null;
        } else if (count == 1) {
            return lists[start];
        } else {
            // 取中间数，count >> 1，2进制向右移动1位，十进制除以2， 8 >> 1 = 4, 8 >> 2 = 2
            int middle = start + (count >> 1);
            ListNode left = mergeLists(lists, start, middle);
            ListNode right = mergeLists(lists, middle, end);

            ListNode head = new ListNode(0);
            ListNode p = head;

            while (left != null && right != null) {
                if (left.val < right.val) {
                    p.next = left;
                    left = left.next;
                } else {
                    p.next = right;
                    right = right.next;
                }
                p = p.next;
            }

            if (left != null)
                p.next = left;
            else if (right != null)
                p.next = right;
            return head.next;
        }
    }

    /**
     * 算法
     *
     * 我们直接将以上递归过程建模，同时需要考虑边界情况。
     *
     * 如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
     *
     * 否则，我们要判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。
     *
     * 如果两个链表有一个为空，递归结束
     * 
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoListNode(ListNode l1, ListNode l2) {
        // 若l1/l2为空，返回相对应的其他的ListNode
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListNode(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListNode(l2.next, l1);
            return l2;
        }
    }
}
