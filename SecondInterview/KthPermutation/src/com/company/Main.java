package com.company;

import java.util.*;

public class Main {

    public String KthPermutation(int n, int k){

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i=1;i<=n;i++){
            numbers.add(i);
        }

        k--;
        int mod = 1;
        for(int i=1;i<=n;i++){
            mod *= i;
        }

        String result = "";

        for(int i=0;i<n;i++){
            mod = mod/(n-i);
            int curIndex = k / mod;
            k %= mod;
            result += numbers.get(curIndex);
            numbers.remove(curIndex);
        }

        return result.toString();
    }
}
