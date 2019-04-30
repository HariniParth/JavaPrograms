package com.company;

public class Main {

    private boolean splitArray(int[] arr){

        int n = arr.length;
        return splitArrayUtil(arr, n, 0, 0, 0);
    }

    private boolean splitArrayUtil(int[] arr, int n, int start, int lsum, int rsum){

        if(start == n)
            return (lsum == rsum);
        if(arr[start] % 5 == 0)
            lsum += arr[start];
        else if(arr[start] % 3 == 0)
            rsum += arr[start];
        else {
            return splitArrayUtil(arr, n, start+1, lsum+arr[start], rsum)
                    || splitArrayUtil(arr, n, start+1, lsum, rsum+arr[start]);
        }
        return splitArrayUtil(arr, n, start+1, lsum, rsum);
    }
}
