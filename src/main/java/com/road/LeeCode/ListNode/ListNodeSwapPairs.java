package com.road.LeeCode.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author Jack Road
 */
public class ListNodeSwapPairs {

    /**
     * 解决方法一
     *
     * 思路
     *
     * 从链表的头节点 head 开始递归。
     * 
     * 每次递归都负责交换一对节点。由 firstNode 和 secondNode 表示要交换的两个节点。
     * 
     * 下一次递归则是传递的是下一对需要交换的节点。若链表中还有节点，则继续递归。
     * 
     * 交换了两个节点以后，返回 secondNode，因为它是交换后的新头。
     * 
     * 在所有节点交换完成以后，我们返回交换后的头，实际上是原始链表的第二个节点
     * 
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // 1. 终止条件：当前没有节点或者只有一个节点，肯定就不需要交换了
        if (head == null || head.next == null) {
            return head;
        }
        // 2. 调用单元，需要交换的两个节点是 head 和 head.next
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        /******************* 巧妙的地方在这里开始 **********************/
        // firstNode 连接后面交换完成的子链表
        firstNode.next = swapPairs(secondNode.next);
        // secondNode 连接 firstNode
        secondNode.next = firstNode;
        /******************* 巧妙的地方在这里结束 ***********************/
        // 3. 返回值：返回交换完成的子链表，secondNode 变成了头结点
        return secondNode;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.setListNode(10);
        ListNode listNode1 = new ListNodeSwapPairs().swapPairs(listNode);
    }
}
