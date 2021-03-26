package com.road.LeeCode.ListNode;

/**
 * 旋转链表
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NUL
 *
 * @author Jack Road
 */
public class ListNodeRotateRight {

    /**
     * 旋转列表
     *
     * @param head 给定的链表
     * @param k 向右移动位置
     * @return 返回结果
     */
    public ListNode rotateRight(ListNode head, int k) {
        // 若空返回
        if (head == null) {
            return null;
        }
        // 若listNode只有一个节点返回
        if (head.next == null) {
            return head;
        }
        // 单链表转循环链表
        ListNode oldTail = head;
        int n;
        // 遍历原始链表长度
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        // 原始链表尾部，指向原始链表头部，形成环形链表
        // 以上for循环遍历完，即遍历到链表最后一个节点，最后一个节点赋值next节点指向头节点
        oldTail.next = head;

        // 找到新的尾结点newTail：（n - k % n - 1）
        // 新的newHead：（n - k % n）
        ListNode newTail = head;
        for (int i = 0; i < (n - k % n -1); i++) {
            System.out.println("k%N:" + k%n);
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // 截断环形链表
        // 截断环形链表的巧妙点在于：
        newTail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
       ListNode listNode =  ListNode.tailSetListNode(5);
       new ListNodeRotateRight().rotateRight(listNode, 2);
    }
}
