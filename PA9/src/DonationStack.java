/*
 * Name: Ganesh Kumarappan
 * PID: A17995383
 */

import java.util.*;

/**
 * TODO
 *
 * @author Ganesh Kumarappan
 * @since 6/9/24
 */

public class DonationStack {
    private static Stack<Integer> stack;

    private static Stack<Integer> maxStack;

    private static int max;

    public DonationStack() {
        // TODO
        stack = new Stack<>();
        maxStack = new Stack<>();
        max = Integer.MIN_VALUE;
    }

    public void push(int val) {
        // TODO
        stack.add(val);
        if(maxStack.isEmpty()){
            maxStack.push(val);
        }
        else{
            maxStack.push(Math.max(val, maxStack.peek()));
        }
    }

    public int peek() {
        // TODO
        return stack.peek();
    }

    public int pop() {
        // TODO
        maxStack.pop();
        return stack.pop();
    }

    public int max() {
        // TODO
        return maxStack.peek();
    }
}