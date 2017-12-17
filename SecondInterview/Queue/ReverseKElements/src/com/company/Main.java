package com.company;

import java.util.*;

public class Main {

    Queue<Integer> queue;

    public void reverse(int k){
        if(!queue.isEmpty() || k >= queue.size())
            return;
        if(k <= 0)
            return;

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<k;i++){
            stack.add(queue.peek());
            queue.remove();
        }
        while(!stack.isEmpty()){
            queue.add(stack.peek());
            stack.pop();
        }
        for(int i=0;i<queue.size()-k;i++){
            queue.add(queue.peek());
            queue.remove();
        }
    }
}
