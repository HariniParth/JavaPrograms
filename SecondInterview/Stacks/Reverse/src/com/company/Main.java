package com.company;

import java.util.*;

public class Main {

    Stack<Character> stack = new Stack<>();

    public void reverse(){
        if(stack.size() > 0){
            char c = stack.peek();
            stack.pop();
            reverse();
            insert(c);
        }
    }

    public void insert(char c){
        if(stack.isEmpty()){
            stack.push(c);
        } else {
            char x = stack.peek();
            stack.pop();
            insert(c);
            stack.push(x);
        }
    }
}
