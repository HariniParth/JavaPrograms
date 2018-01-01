package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

public class Main {

    public int minimumPlatform(int[] arr, int[] dep, int n){

        Arrays.sort(arr);
        Arrays.sort(dep);

        int platform = 1, result = 0;
        int i = 1, j = 0;

        while(i < n && j < n){
            if(arr[i] < dep[j]){
                platform++;
                i++;

                if(platform > result)
                    result = platform;
            } else {
                platform--;
                j++;
            }
        }
        return result;
    }
}
