package com.company;

import java.util.*;

public class Main {

    private Queue<Integer> queue;

    private void interLeave(){

        // Q: 1 2 3 4 5 6 7 8 9 0
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<queue.size()/2;i++){
            stack.push(queue.peek());
            queue.remove();
        }
        // Q: 6 7 8 9 0
        // S: 5 4 3 2 1
        for(int i=0;i<stack.size();i++){
            queue.add(stack.peek());
            stack.pop();
        }
        // Q: 6 7 8 9 0 5 4 3 2 1
        for(int i=0;i<queue.size()/2;i++){
            queue.add(queue.peek());
            queue.remove();
        }
        // Q: 5 4 3 2 1 6 7 8 9 0
        for(int i=0;i<queue.size()/2;i++){
            stack.push(queue.peek());
            queue.remove();
        }
        // Q: 6 7 8 9 0
        // S: 1 2 3 4 5
        while(!stack.isEmpty()){
            queue.add(stack.peek());
            stack.pop();
            queue.add(queue.peek());
            queue.remove();
        }
        // Q: 1 6 2 7 3 8 4 9 5 0
    }
}