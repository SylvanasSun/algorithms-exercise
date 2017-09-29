package com.sylvanas.algorithms_exercise.linked_list;

/**
 * 在O(1)时间复杂度删除链表节点
 * 给定一个单链表中的一个等待被删除的节点(非表头或表尾)。请在在O(1)时间复杂度删除该链表节点。
 * Example: Linked list is 1->2->3->4, and given node 3, delete the node in place 1->2->4
 *
 * Created by SylvanasSun on 9/28/2017.
 */
public class DeleteLinkedlistNode {

    /**
     * 将node节点(待删除)的next节点的值复制给node,然后删除next节点.
     */
    public static void solution(ListNode node) {
        if (node == null)
            return;

        ListNode next = node.next;
        if (next != null) {
            node.val = next.val;
            node.next = next.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 4; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        solution(head.next.next);
        assert head.val == 1;
        assert head.next.val == 2;
        assert head.next.next.val == 4;
    }

}
