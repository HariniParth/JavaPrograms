package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/

public class Main {

    private int[] deno = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
    private int n = deno.length;

    public void minimumCoins(int sum){

        ArrayList<Integer> coins = new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            if(sum > deno[i]){
                coins.add(deno[i]);
                sum -= deno[i];
            }
        }

        for(int i=0;i<coins.size();i++)
            System.out.print(coins.get(i)+" ");

    }
}
