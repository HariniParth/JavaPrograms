package com.company;

// https://www.geeksforgeeks.org/median-of-two-sorted-arrays/

public class Main {

    private int getMedian(int[] arr1, int[] arr2){

        int n = arr1.length;
        if(arr2.length != n)
            return -1;

        int i = 0, j = 0;
        int count;
        int m1 = -1, m2 = -1;

        for(count=0;count<n;count++){
            if(i == n){
                m1 = m2;
                m2 = arr2[0];
                break;
            }
            else if(j == n){
                m1 = m2;
                m2 = arr1[0];
                break;
            }
            if(arr1[i] < arr2[j]){
                m1 = m2;
                m2 = arr1[i];
                i++;
            } else {
                m1 = m2;
                m2 = arr2[j];
                j++;
            }
        }
        return (m1+m2)/2;
    }
}
