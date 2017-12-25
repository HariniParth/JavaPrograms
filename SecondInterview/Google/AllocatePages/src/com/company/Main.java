package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/allocate-minimum-number-pages/

public class Main {

    public int allocatePages(int[] arr, int n, int m){
        if(n < m)
            return -1;

        int result = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }

        int start = 0, end = sum;
        while(start <= end){
            int mid = (start + end) / 2;
            if(isPossible(arr, n, m, mid)){
                result = Math.min(result, mid);
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return result;
    }

    public boolean isPossible(int[] arr, int n, int m, int mid){
        int studentCount = 0;
        int curr_sum = 0;

        for(int i=0;i<n;i++){
            if(arr[i] > mid)
                return false;

            if(curr_sum + arr[i] > mid){
                curr_sum = arr[i];
                studentCount++;

                if(studentCount > m)
                    return false;
            }
            curr_sum += arr[i];
        }
        return true;
    }

}
