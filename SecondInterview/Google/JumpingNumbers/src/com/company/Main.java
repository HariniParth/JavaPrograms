package com.company;

import java.util.*;

public class Main {

    public void jumpingNumbers(int num, int x){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while(!queue.isEmpty()){
            num = queue.peek();
            queue.remove();

            if(num <= x){
                System.out.println(num);
                int n = num % 10;
                if(n == 0)
                    queue.add((num * 10) + (n+1));
                else if(n == 9)
                    queue.add((num * 10) + (n-1));
                else {
                    queue.add((num * 10) + (n-1));
                    queue.add((num * 10) + (n+1));
                }
            }
        }
    }
}
