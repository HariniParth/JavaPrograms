package com.company;

import java.util.*;

public class Main {

    Queue<Integer> queue;

    private void reverseKElements(int k){

        if(queue.isEmpty())
            return;
        if(k >= queue.size() || k < 0)
            return;

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<k;i++){
            stack.push(queue.peek());
            queue.remove();
        }
        while(!stack.isEmpty()){
            queue.add(stack.peek());
            stack.pop();
        }
        for(int i=0;i<k;i++){
            queue.add(queue.peek());
            queue.remove();
        }
    }
}