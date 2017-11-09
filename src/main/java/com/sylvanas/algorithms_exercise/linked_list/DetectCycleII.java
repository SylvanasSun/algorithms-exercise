package com.sylvanas.algorithms_exercise.linked_list;

/**
 * 带环链表 II
 * 给定一个链表，如果链表中存在环，则返回到链表中环的起始节点，如果没有环，返回null。
 *
 * Created by SylvanasSun on 11/9/2017.
 */
public class DetectCycleII {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode front = head;
        ListNode back = head;

        // 先找出是否有环
        while (front != null && front.next != null) {
            front = front.next.next;
            back = back.next;

            if (front == back)
                break;
        }

        // 找出环的起始节点
        if (front != null && front == back) {
            front = head;
            while (front != back) {
                front = front.next;
                back = back.next;
            }

            return front;
        } else {
            return null;
        }
    }

}
