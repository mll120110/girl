package com.road.LeeCode.ListNode;

/**
 * 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 *
 * @author Jack Road
 */
public class ListNodeTwoSumPlus {
    /**
     * 内部Node节点类
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 算法思路
     *
     * 将当前结点初始化为返回列表的哑结点。
     * 
     * 将进位 carry初始化为 0。
     * 
     * 将 p 和 q 分别初始化为列表 l1 和 l2 的头部。
     * 
     * 遍历列表 l1 和 l2 直至到达它们的尾端。
     * 
     * 将 x 设为结点 p 的值。如果 p 已经到达 l1的末尾，则将其值设置为 0。
     * 
     * 将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
     * 
     * 设定 sum = x + y + carry。
     * 
     * 更新进位的值，carry = sum / 10。
     * 
     * 创建一个数值为 (sum mod 10)的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
     * 
     * 同时，将 p 和 q 前进到下一个结点。
     * 
     * 检查 carry = 1 是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
     *
     * 返回哑结点的下一个结点。
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    public ListNode addTwoNumber(ListNode listNode1, ListNode listNode2) {
        // 初始化一个单链表
        ListNode dumpHead = new ListNode(0);
        // 将单链表节点赋值给p,q,curr
        ListNode p = listNode1, q = listNode2, curr = dumpHead;
        // 将进位 carry初始化为 0
        int carry = 0;
        // 遍历列表 l1 和 l2 直至到达它们的尾端
        while (p != null || q != null) {
            // 将 x 设为结点 p 的值。如果 p 已经到达 l1的末尾，则将其值设置为 0
            int x = (p != null) ? p.val : 0;
            // 将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0
            int y = (q != null) ? q.val : 0;
            // 设定 sum = x + y + carry
            int sum = carry + x + y;
            // 更新进位的值
            carry = sum / 10;
            // 创建一个数值为 (sum mod 10)的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dumpHead.next;
    }
}
