package com.road.LeeCode.ListNode;

import java.util.HashMap;

/**
 * 链表数组
 *
 * @author Jack Road
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    /**
     * 初始化ListNode大小
     *
     * @param x
     */
   public ListNode(int x) {
        setListNode(x);
    }

    public ListNode(int val, ListNode listNode) {
       this.val = val;
       this.next = listNode;
    }

    /**
     * 设置ListNode长度，并使用尾插法
     *
     * @param length 链表长度
     * @return 链表
     */
    public static ListNode setListNode(int length) {
        // 默认返回尾插法ListNode
        return tailSetListNode(length);
    }

    /**
     * 设置ListNode长度
     *
     * @param length 链表长度
     * @param tail 头插还是尾插
     * @return ListNode
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
     * @param length listNode的长度
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
     * @param length listNode的长度
     * @return ListNode
     */
    public static ListNode tailSetListNode(int length) {
        ListNode newListNode, head = null, tail = null;
        for (int i = 0; i < length; i++) {
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
        // head在第一次赋值的时候已经获取到内存地址，当前的next指针会指向下个对象地址
        return head;
    }

    public static void main(String[] args) {
        ListNode.tailSetListNode(5);
        HashMap<String, String> hashMap = new HashMap<>(16);
    }
}
