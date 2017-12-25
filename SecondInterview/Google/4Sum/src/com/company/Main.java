package com.company;

import java.util.*;

public class Main {

    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int sum){

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(arr == null || arr.length == 0)
            return result;

        int n = arr.length;
        for(int i=0;i<n-3;i++){
            if(i != 0 && arr[i] == arr[i-1])
                continue;

            for(int j=i+1;j<n-2;j++){
                if(j != i+1 && arr[j] == arr[j-1])
                    continue;

                int k = j + 1;
                int l = arr.length - 1;

                if(arr[i] + arr[j] + arr[k] + arr[l] < sum)
                    k++;
                else if(arr[i] + arr[j] + arr[k] + arr[l] > sum)
                    l--;
                else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    temp.add(arr[l]);
                    result.add(temp);

                    k++;
                    l--;

                    if(k < l && arr[k] == arr[k-1])
                        k++;
                    if(k < l && arr[l] == arr[l+1])
                        l++;
                }
            }
        }
        return result;
    }
}
