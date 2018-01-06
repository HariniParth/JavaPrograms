package com.company;

// https://www.interviewcake.com/question/java/stock-price

// Greedy approach, O(n) time complexity, O(1) Space complexity

import java.util.*;

public class Main {

    public int maxProfit(List<Integer> stockPrice){

        int minPrice = stockPrice.get(0);
        int maxProfit = stockPrice.get(1) - stockPrice.get(0);

        for(int i=1;i<stockPrice.size();i++){
            int currprice = stockPrice.get(i);
            int newProfit = currprice - minPrice;

            maxProfit = Math.max(maxProfit, newProfit);
            minPrice = Math.min(minPrice, currprice);
        }

        return maxProfit;
    }
}
