/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyandsellstock;

import java.util.List;


/**
 *
 * @author harini-geek
 */
public class BuyAndSellStock {

    public int BuyAndSellStock(List<Integer> stock){
        
        int n = stock.size();
        if(n == 0)
            return 0;
        int [] price = new int[n];
        
        for(int i=1;i<n;i++){
            price[i-1] = stock.get(i) - stock.get(i-1);
        }
        
        int profit = 0, prev = 0, last = 0;
        
        for(int i=0;i<n;i++){
            last = price[i];
            if(last < prev){
                profit += prev;
                prev = 0;
                last = 0;
            } else {
                prev = last;
            }
        }
        profit += prev;
        
        return profit;
    }
    
}
