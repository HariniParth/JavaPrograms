package com.company;

import java.util.*;

public class Main {

    Queue<Integer> queue;

    public void reverse(){

        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            stack.add(queue.peek());
            queue.remove();
        }
        while(!stack.isEmpty()){
            queue.add(stack.peek());
            stack.pop();
        }
    }
}
