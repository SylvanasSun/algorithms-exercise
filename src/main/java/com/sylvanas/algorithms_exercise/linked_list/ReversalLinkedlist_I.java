package com.sylvanas.algorithms_exercise.linked_list;

/**
 * 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
 * 挑战: 在原地一次翻转完成
 *
 * Created by SylvanasSun on 9/28/2017.
 */
public class ReversalLinkedlist_I {

    public static ListNode solution(ListNode head) {
        if (head == null)
            return null;

        ListNode n = head;
        ListNode pre = null;
        ListNode post = null;

        while (n != null) {
            post = n.next;
            n.next = pre;
            pre = n;
            n = post;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 3; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode solution = solution(head);
        int counter = 3;
        while (solution != null) {
            assert solution.val == counter;
            counter--;
            solution = solution.next;
        }
    }

}
