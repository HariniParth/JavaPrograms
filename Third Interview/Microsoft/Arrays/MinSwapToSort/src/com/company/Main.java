package com.company;

import javafx.util.Pair;

import java.util.*;

// https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/

public class Main {

    private int minSwapsToSort(int[] arr){

        ArrayList<Pair<Integer, Integer>> arrPos = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            arrPos.add(new Pair<>(arr[i], i));
        }

        arrPos.sort(new Comparator<Pair<Integer, Integer>>(){
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
                if(p1.getKey() > p2.getKey()){
                    return -1;
                }
                else if(p1.getKey().equals(p2.getKey())){
                    return 0;
                }
                else {
                    return 1;
                }
            }
        });

        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);
        int result = 0;

        for(int i=0;i<arr.length;i++){
            if(visited[i] || arrPos.get(i).getValue() == i)
                continue;

            int j = i;
            int carry = 0;
            while(!visited[j]){
                visited[j] = true;
                j = arrPos.get(j).getValue();
                carry++;
            }
            if(carry > 0)
                result += carry - 1;
        }
        return result;
    }
}