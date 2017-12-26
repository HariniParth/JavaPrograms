package com.company;

// https://discuss.leetcode.com/topic/59889/dice-roll/3

public class Main {

    public int findWays(int dices, int faces, int sum){

        if(sum < faces || sum > dices * faces)
            return -1;

        int[][] ways = new int[dices+1][sum+1];

        for(int i=1; i<=faces && i<= sum; i++)
            ways[1][i] = 1;

        for(int dice=2;dice<=dices;dice++){
            for(int n=1;n<=sum;n++){
                for(int face=1;face<=faces && face<sum;face++)
                    ways[dice][sum] += ways[dice-1][sum-face];
            }
        }

        return ways[dices][sum];
    }
}
