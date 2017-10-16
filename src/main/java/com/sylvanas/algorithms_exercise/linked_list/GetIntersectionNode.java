package com.sylvanas.algorithms_exercise.linked_list;

import java.util.Stack;

/**
 * 两个链表的交叉
 * 请写一个程序，找到两个单链表最开始的交叉节点。
 * 如果两个链表没有交叉，返回null。
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 *
 * Created by SylvanasSun on 10/16/2017.
 */
public class GetIntersectionNode {

    /**
     * 使用2个Stack记录链表A与链表B(因为后进先出,所以栈顶为链表尾部),然后从后向前比较.
     */
    public static ListNode getInersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        ListNode tempA = headA;
        while (tempA != null) {
            stackA.push(tempA);
            tempA = tempA.next;
        }

        ListNode tempB = headB;
        while (tempB != null) {
            stackB.push(tempB);
            tempB = tempB.next;
        }

        ListNode result = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek()) {
                result = stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }

        return result;
    }

}
