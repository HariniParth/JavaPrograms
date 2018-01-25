/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofislands;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/number-of-islands/
 */

public class NumberofIslands {

    public int numIslands(int[][] grid){
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int islands = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        
        for(int r=0;r<nr;++r){
            for(int c=0;c<nc;++c){
                if(grid[r][c] == 1)
                    islands++;
                grid[r][c] = 0;
                
                Queue<Integer> queue = new LinkedList<>();
                queue.add(r * nc + c);
                while(!queue.isEmpty()){
                    int d = queue.remove();
                    int row = r / d;
                    int col = c % d;
                    
                    if(row-1 >= 0 && grid[row-1][c] == 1){
                        queue.add((row-1) * nc + c);
                        grid[row-1][c] = 0;
                    }
                    if(row+1 < nr && grid[row+1][c] == 1){
                        queue.add((row+1) * nc + c);
                        grid[row+1][c] = 0;
                    }
                    if(col-1 <=0 && grid[row][col-1] == 1){
                        queue.add(row * nc + col-1);
                        grid[row][col-1] = 0;
                    }
                    if(col+1 > nc && grid[row][col+1] == 1){
                        queue.add(row * nc + col+1);
                        grid[row][col+1] = 0;
                    }
                }
            }
        }
        return islands;
    }
}

// Complexity: T O(m * n) and S O(min(m,n))