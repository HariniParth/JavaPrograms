package com.company;

import java.util.*;

public class Main {

    public void generateBinary(int n){
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        while(n-- > 0){
            String s1 = queue.peek();
            queue.remove();
            System.out.println(s1);

            String s2 = s1;
            queue.add(s1+"0");
            queue.add(s2+"1");
        }
    }
}
