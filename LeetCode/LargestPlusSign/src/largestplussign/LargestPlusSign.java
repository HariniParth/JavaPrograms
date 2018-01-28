/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestplussign;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/largest-plus-sign/
 */

public class LargestPlusSign {

    public int largestPlusSign(int N, int[][] mines){
        
        HashSet<Integer> bannedSet = new HashSet<>();
        int[][] grid = new int[N][N];
        
        for(int[] mine : mines)
            bannedSet.add(mine[0] * N + mine[1]);
        
        int result = 0, count;
        
        for(int r=0;r<N;++r){
            count = 0;
            for(int c=0;c<N;++c){
                count = bannedSet.contains(r * N + c)? 0 : count+1;
                grid[r][c] = count;
            }
            
            count = 0;
            for(int c=N-1;c>=0;--c){
                count = bannedSet.contains(r * N + c)? 0 : count+1;
                grid[r][c] = Math.min(grid[r][c], count);
            }
        }
        
        for(int c=0;c<N;++c){
            count = 0;
            for(int r=0;r<N;++r){
                count = bannedSet.contains(r * N + c)? 0 : count+1;
                grid[r][c] = Math.min(grid[r][c], count);
            }
            
            count = 0;
            for(int r=N-1;r>=0;--r){
                count = bannedSet.contains(r * N + c)? 0 : count+1;
                grid[r][c] = Math.min(grid[r][c], count);
                result = Math.max(result, grid[r][c]);
            }
        }
        
        return result;
    }
}

// Time and Space Complexity: O(n^2)