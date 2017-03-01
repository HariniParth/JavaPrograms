/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

/**
 *
 * @author harini-geek
 */
public class Knapsack {

    public int knapsack(int[] val, int[] wt, int W){
        
        int[][] K = new int[val.length+1][W+1];
        for(int i=0;i<=val.length;i++){
            for(int j=0;j<=W;j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                
                if(j - wt[i-1] >= 0){
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1] + val[i-1]]);
                } else {
                    K[i][j] = K[i-1][j];
                }
            }
        }
        return K[val.length][W];
    }
    
}
