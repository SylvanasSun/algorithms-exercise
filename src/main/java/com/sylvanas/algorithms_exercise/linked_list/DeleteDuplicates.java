package com.sylvanas.algorithms_exercise.linked_list;

/**
 * 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素每个元素只留下一个。
 *
 * Created by SylvanasSun on 10/27/2017.
 */
public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode n = head;
        ListNode next = null;

        while (n != null) {
            next = n.next;
            if (next != null && n.val == next.val)
                n.next = next.next;
            else
                n = n.next;
        }

        return head;
    }

}
