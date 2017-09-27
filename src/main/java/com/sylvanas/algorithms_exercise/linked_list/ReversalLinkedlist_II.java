package com.sylvanas.algorithms_exercise.linked_list;

/**
 * 翻转链表中第m个节点到第n个节点的部分
 * m，n满足1 ≤ m ≤ n ≤ 链表长度
 * Example: 给出链表1->2->3->4->5->null， m = 2 和n = 4，返回1->4->3->2->5->null
 *
 * Created by SylvanasSun on 9/27/2017.
 */
public class ReversalLinkedlist_II {

    /**
     * 先找到m节点所在的位置,然后根据位置将链表断开,这样就形成了两个链表.
     * 然后将第二个链表依次取头节点做旋转,最终再将链表合并.
     */
    public static ListNode solution(ListNode head, int m, int n) {
        if (m >= n || head == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        // 找到m节点的前节点
        for (int i = 1; i < m; i++) {
            if (head == null)
                return null;
            head = head.next;
        }

        ListNode pre_node = head;
        ListNode m_node = pre_node.next;
        ListNode n_node = m_node;
        ListNode post_node = m_node.next;

        // 从第二部分链表开始翻转
        for (int i = m; i < n; i++) {
            if (post_node == null)
                return null;
            ListNode temp = post_node.next;
            post_node.next = n_node;
            n_node = post_node;
            post_node = temp;
        }

        m_node.next = post_node;
        pre_node.next = n_node;
        return dummy.next;
    }

}
