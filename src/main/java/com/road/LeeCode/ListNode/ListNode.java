package com.road.LeeCode.ListNode;

/**
 * 链表数组
 *
 * @author Jack Road
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int x) {
        val = x;
    }

    /**
     * 设置ListNode长度，并使用尾插法
     *
     * @param length
     * @return
     */
    public static ListNode setListNode(int length) {
        // 默认返回尾插法ListNode
        return tailSetListNode(length);
    }

    /**
     * 设置ListNode长度
     * 
     * @param length
     * @param tail
     * @return
     */
    public static ListNode setListNode(int length, boolean tail) {
        // 若是tail(true),返回尾插法ListNode
        if (tail) {
            return tailSetListNode(length);
        } else {
            return headSetListNode(length);
        }
    }

    /**
     * 设置listNode列表,并使用头插法插入数据
     *
     * @param length
     *            listNode的长度
     * @return ListNode
     */
    public static ListNode headSetListNode(int length) {
        ListNode nextNode, head = null;
        for (int i = 0; i < length; i++) {
            // 创建一个临时节点
            nextNode = new ListNode(0);
            // 为属性赋值
            nextNode.val = i;
            if (head == null) {
                head = nextNode;
            } else {
                // 将新节点连接到链表头部
                nextNode.next = head;
                // head永远存储第一个节点的地址
                head = nextNode;
            }
        }
        return head;
    }

    /**
     * ListNode尾插法，插入指定ListNode节点
     * 
     * @param length
     *            listNode的长度
     * @return ListNode
     */
    public static ListNode tailSetListNode(int length) {
        ListNode newListNode, head = null, tail = null;
        for (int i = 0; i < length; i++) {
            newListNode = new ListNode(0);
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
        return head;
    }

    public static void main(String[] args) {
        ListNode.tailSetListNode(5);
    }
}
