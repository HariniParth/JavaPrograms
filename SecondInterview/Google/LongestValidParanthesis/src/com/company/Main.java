package com.company;

import java.util.*;

public class Main {

    public int paranthesis(String s){
        int max = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isValid(s.substring(i, j)))
                    max = Math.max(max, j-i);
            }
        }
        return max;
    }

    public boolean isValid(String s){

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else if(!stack.isEmpty() && stack.peek() == '(')
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();
    }
}
