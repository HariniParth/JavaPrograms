/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsetsum;

/**
 *
 * @author harini-geek
 */
public class SubsetSum {

    public boolean subsetSum(int[] arr, int total){
     
        boolean[][] solution = new boolean[arr.length+1][total+1];
        for(int i=0;i<arr.length;i++){
            solution[i][0] = true;
        }
        
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=total;j++){
                if(j - arr[i-1] >= 0){
                    solution[i][j] = solution[i-1][j] || solution[i-1][j-arr[i-1]];
                } else {
                    solution[i][j] = solution[i-1][j];
                }
            }
        }
        
        return solution[arr.length][total];
    }
    
}
