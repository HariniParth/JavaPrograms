/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toeplitzmatrix;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/toeplitz-matrix/
 */

public class ToeplitzMatrix {

   public boolean isToeplitzMatrix(int[][] matrix){
       for(int r=0;r<matrix.length;++r)
           for(int c=0;c<matrix[0].length;++c)
               if(r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                   return false;
       
       return true;
   }
    
}

// Complexity: Time O(m * n), Space O(1)