package com.company;

public class Main {

    public boolean partition(int[] arr){

        int n = arr.length;
        int sum = 0;

        for(int i=0;i<n;i++){
            sum += arr[i];
        }

        int lsum = 0;
        for(int i=0;i<n-1;i++){
            lsum += arr[i];
            int rsum = sum - lsum;

            if(lsum * (n-i+1) == rsum * (i+1)) {
                System.out.println("From: " + arr[0] + " to " + arr[i] + " and " + arr[i + 1] + " to " + arr[n - 1]);
                return true;
            }
        }

        return false;
    }
}
