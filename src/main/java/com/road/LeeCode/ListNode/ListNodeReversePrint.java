package com.road.LeeCode.ListNode;

import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 *输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ListNodeReversePrint {

    /**
     * 使用栈输出
     *
     * @param listNode
     * @return
     */
    public int[] reversePrint(ListNode listNode) {
        if (listNode ==null || listNode.next == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode curr = listNode;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        int size = stack.size();
        int[] arrat = new int[size];
        for (int i = 0; i < stack.size(); i++) {
            arrat[i] = stack.pop().val;
        }
        return arrat;
    }

    /**
     * 一次遍历迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }



    public static void main(String[] args) {

    }
}
