package com.company;

public class Main {

    public int sumBitDiff(int[] arr){

        int n = arr.length;
        int res = 0;

        for(int i=0;i<32;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(arr[j] * (1 << i) == 1)
                    count++;

                res += count * (n - count) * 2;
            }
        }

        return res;
    }
}
