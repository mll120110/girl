package com.road.LeeCode.ListNode;

/**
 * K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 */
public class ListNodeKSwapPairs {
    /**
     * 解决一
     *
     * 思路
     *
     * 1、找到待翻转的k个节点（注意：若剩余数量小于 k 的话，则不需要反转，因此直接返回待翻转部分的头结点即可）。
     * 
     * 2、对其进行翻转。并返回翻转后的头结点（注意：翻转为左闭又开区间，所以本轮操作的尾结点其实就是下一轮操作的头结点）。
     * 
     * 3、对下一轮 k 个节点也进行翻转操作。
     * 
     * 4、将上一轮翻转后的尾结点指向下一轮翻转后的头节点，即将每一轮翻转的k的节点连接起来。
     *
     * @param head
     * @param k
     * @return ListNode
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        // 从head节点开始遍历k个元素间隔，到达tail指定的元素
        for (int i = 0; i < k; i++) {
            // 剩余数量小于k的话，则不需要反转
            if (tail == null) {
                return head;
            }
            // 找到从head开始到第k个元素节点
            tail = tail.next;
            System.out.println("tail: " + tail.val);
        }
        // 反转前k个元素
        ListNode newHead = reverse(head, tail);
        // 下一轮的开始的地方是tail
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    /**
     * 左闭右开区间
     * 
     * @param head
     * @param tail
     * @return ListNode
     */
    private static ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNodeKSwapPairs.reverseKGroup(ListNode.setListNode(10), 3);
    }
}
