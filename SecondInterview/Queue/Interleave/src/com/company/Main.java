package com.company;

import java.util.*;

public class Main {

    Queue<Integer> queue;

    public void interleave(){

        // Q: 11 12 13 14 15 16 17 18 19 20
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<queue.size()/2;i++){
            stack.add(queue.peek());
            queue.remove();
        }
        // S: 15 14 13 12 11
        // Q: 16 17 18 19 20

        while(!stack.isEmpty()){
            queue.add(stack.peek());
            stack.pop();
        }
        // Q: 16 17 18 19 20 15 14 13 12 11

        for(int i=0;i<queue.size()/2;i++){
            queue.add(queue.peek());
            queue.remove();
        }
        // Q: 15 14 13 12 11 16 17 18 19 20

        for(int i=0;i<queue.size()/2;i++){
            stack.add(queue.peek());
            queue.remove();
        }
        // S: 11 12 13 14 15
        // Q: 16 17 18 19 20

        while(!stack.isEmpty()){
            queue.add(stack.peek());
            stack.pop();
            queue.add(queue.peek());
            queue.remove();
        }
        // Q: 11 16 12 17 13 18 14 19 15 20
    }

}
