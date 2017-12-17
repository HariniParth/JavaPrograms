package com.company;

import java.util.*;

public class Main {

    static final int max_char = 26;

    public void nonRepeatingChar(String s){

        int[] charCount = new int[max_char];
        Queue<Character> queue = new LinkedList<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            queue.add(c);
            charCount[i]++;

            while(!queue.isEmpty()){
                if(charCount[queue.peek() - 'a'] > 1)
                    queue.remove();
                else {
                    System.out.println(queue.peek()+" ");
                    break;
                }
            }
            if(queue.isEmpty())
                System.out.print(-1+" ");
        }
        System.out.println();
    }
}
