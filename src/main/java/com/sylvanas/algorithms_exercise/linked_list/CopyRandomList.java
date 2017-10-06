package com.sylvanas.algorithms_exercise.linked_list;

/**
 * 复制带随机指针的链表
 * 给出一个链表，每个节点包含一个额外增加的随机指针可以指向链表中的任何节点或空的节点。
 * 返回一个深拷贝的链表。
 *
 * Created by SylvanasSun on 10/6/2017.
 */
public class CopyRandomList {

    public static RandomListNode solution(RandomListNode head) {
        if (head == null)
            return null;

        // 在原链表的每个节点后面插入一个新的节点(copy节点)
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // 依次给新的节点(copy节点)的随机指针赋值
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random;
            cur = cur.next.next;
        }

        // 将两个链表分离
        cur = head;
        RandomListNode result = cur.next;
        while (cur != null) {
            RandomListNode temp = cur.next;
            cur.next = temp.next;
            if (temp.next != null)
                temp.next = temp.next.next;
            cur = cur.next;
        }

        return result;
    }

}
