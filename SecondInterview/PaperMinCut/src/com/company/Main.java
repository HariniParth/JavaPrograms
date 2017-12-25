package com.company;

public class Main {

    public int minCut(int m, int n){

        if(n > m){
            m = m + n;
            n = m - n;
            m = m - n;
        }

        long result = 0, rem = 0;

        while(n > 0){
            result += m/n;
            rem = m % n;
            m = n;
            n = (int) rem;
        }

        return (int) result;
    }
}
