package com.sylvanas.algorithms_exercise.linked_list;

/**
 * 将两个排序链表合并为一个新的排序链表
 * Example:
 * 给出 1->3->8->11->15->null，2->null， 返回 1->2->3->8->11->15->null。
 *
 * Created by SylvanasSun on 9/29/2017.
 */
public class MergeTwoLists {

    /**
     * 使用一个链表接受l1和l2中的元素(重排序)
     */
    public static ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        // 按照顺序构建链表
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        // 如果l1或者l2还有剩余元素,则追加到链表后
        if (l1 != null)
            node.next = l1;
        if (l2 != null)
            node.next = l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(8);
        l1.next.next.next = new ListNode(11);
        l1.next.next.next.next = new ListNode(15);

        ListNode l2 = new ListNode(2);
        ListNode head = solution(l1, l2);

        assert head.val == 1;
        assert head.next.val == 2;
        assert head.next.next.val == 3;
        assert head.next.next.next.val == 8;
        assert head.next.next.next.next.val == 11;
        assert head.next.next.next.next.next.val == 15;
    }

}
