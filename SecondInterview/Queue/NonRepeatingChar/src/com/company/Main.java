package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-character-in-a-stream/

public class Main {

    static final int max_chars = 26;

    private void nonRepeatingChars(String s){

        int n = s.length();
        int[] count = new int[max_chars];
        Queue<Character> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            queue.add(ch);
            count[ch - 'a']++;
            while(!queue.isEmpty()){
                if(count[ch - 'a'] > 1)
                    queue.remove();
                else {
                    System.out.print(ch+" ");
                    break;
                }
            }
            if(queue.isEmpty())
               System.out.print(" ");
        }
    }
}