package com.sylvanas.algorithms_exercise.stack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 带最小值操作的栈
 * 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
 * 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
 *
 * Created by SylvanasSun on 10/10/2017.
 */
public class MinStack {

    private Stack<Integer> data;

    private Stack<Integer> minimum;

    public MinStack() {
        this.data = new Stack<>();
        this.minimum = new Stack<>();
    }

    public void push(int number) {
        data.push(number);
        // 如果number小于或等于minimum栈顶,则入栈.
        // 否则,为了保持与data大小一致将栈顶的最小值重复入栈
        if (minimum.size() == 0 || minimum.peek() >= number)
            minimum.push(number);
        else
            minimum.push(minimum.peek());
    }

    public int pop() {
        if (data.size() > 0 && minimum.size() > 0) {
            minimum.pop();
            return data.pop();
        }
        return -1;
    }

    public int min() {
        if (data.size() > 0 && minimum.size() > 0)
            return minimum.peek();
        return -1;
    }

}
