package com.company;

import java.util.*;

public class Main {

    public int mean(int[] arr){
        int sum = 0;
        int avg = 0;
        int l = arr.length;

        for(int i=0;i<l;i++){
            sum += arr[i];
        }

        avg = sum / l;
        return avg;
    }

    public int median(int[] arr){
        int l = arr.length;
        int[] sort = new int[l];
        System.arraycopy(arr, 0, sort, 0, sort.length);
        Arrays.sort(sort);

        if(sort.length % 2 == 0)
            return (sort[sort.length/2 - 1] + sort[sort.length/2])/2;
        else
            return sort[sort.length/2];
    }

    public int mode(int[] arr){
        int max = 0, maxCount = 0;
        int l = arr.length;

        for(int i=0;i<l-1;i++){
            int count = 0;
            for(int j=i+1;j<l;j++){
                if(arr[i] == arr[j])
                    count++;
            }
            if(count > maxCount){
                maxCount = count;
                max = arr[i];
            }
        }
        return max;
    }
}
