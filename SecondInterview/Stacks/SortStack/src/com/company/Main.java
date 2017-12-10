package com.company;

import java.util.*;

public class Main {

    Stack<Integer> stack = new Stack<>();

    public void sortStack(Stack<Integer> stack){
        if(stack.size() > 0){
            int x = stack.pop();
            sortStack(stack);
            sortedInsert(stack, x);
        }
    }

    public void sortedInsert(Stack<Integer> stack, int x){
        if(stack.isEmpty() || x > stack.peek()){
            stack.push(x);
            return;
        } else {
            int temp = stack.pop();
            sortedInsert(stack, x);
            stack.push(temp);
        }
    }
}
