package com.company;

import java.util.*;

public class Main {

    private void generateBinaryNumbers(int n){

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        while(n-- > 0){
            String s1 = queue.peek();
            queue.remove();
            System.out.print(s1+"\n");

            String s2 = s1;
            queue.add(s2+"0");
            queue.add(s2+"1");
        }
    }
}