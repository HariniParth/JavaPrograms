/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixminsumpath;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author harini-geek
 */
public class MatrixMinSumPath {

    int[][] count;
    ArrayList<ArrayList<Integer>> list;
    
    public int solution(ArrayList<ArrayList<Integer>> list){
        
        if(list == null || list.isEmpty() || list.get(0).isEmpty())
            return 0;
        
        int m = list.size();
        int n = list.get(0).size();
        count = new int[m][n];
        
        for(int i=0;i<m;i++){
            Arrays.fill(count[i], Integer.MAX_VALUE);
        }
        
        count[0][0] = list.get(0).get(0);
        this.list = list;
        minSumPath(m-1, n-1);
        
        return count[m-1][n-1];
        
    }
    
    private int minSumPath(int i, int j){
        if(i < 0 || j < 0)
            return Integer.MAX_VALUE;
        if(count[i][j] != Integer.MAX_VALUE)
            return count[i][j];
        
        int result = minSumPath(i-1, j);
        result = Math.min(result, minSumPath(i,j-1));
        count[i][j] = result + list.get(i).get(j);
        return count[i][j];
    }
    
}
