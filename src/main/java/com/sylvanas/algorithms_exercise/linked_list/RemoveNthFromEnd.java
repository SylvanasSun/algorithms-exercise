package com.sylvanas.algorithms_exercise.linked_list;

/**
 * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。
 * Example:
 * 给出链表1->2->3->4->5->null和 n = 2.
 * 删除倒数第二个节点之后，这个链表将变成1->2->3->5->null.
 *
 * Created by SylvanasSun on 9/29/2017.
 */
public class RemoveNthFromEnd {

    /**
     * 先找到节点n(正序),然后用另一个head指针遍历出倒数n的节点
     */
    public static ListNode solution(ListNode head, int n) {
        if (head == null || n <= 0)
            return null;

        ListNode p1 = head;

        // 找到n节点(正序)
        for (int i = 1; i < n; i++) {
            ListNode next = p1.next;
            if (next == null)
                return null;
            else
                p1 = next;
        }

        ListNode p2 = head;
        ListNode pre = null;
        // 找到n节点(倒数)的前一节点
        while (p1.next != null) {
            pre = p2;
            p1 = p1.next;
            p2 = p2.next;
        }

        // 如果n节点(倒数)为head节点
        if (p2 == head)
            head = head.next;
        else
            pre.next = p2.next; // 删除n节点(倒数)

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        solution(head, 2);
        while (head != null) {
            assert head.val != 4;
            head = head.next;
        }
    }

}
