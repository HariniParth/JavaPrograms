/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitarrayconssubsequence;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/split-array-into-consecutive-subsequences/
 */

public class SplitArrayConsSubsequence {

    public boolean splitArrayConsSubsequence(int[] arr){
        
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> tails = new HashMap<>();
        
        for(int n : arr)
            count.put(n, 1);
        
        for(int n : arr){
            if(tails.get(n) > 0){
                tails.put(n, -1);
                tails.put(n+1, 1);
            }
            else if(count.get(n+1) > 0 && count.get(n+2) > 0){
                count.put(n+1, -1);
                count.put(n+2, -1);
                tails.put(n+3, 1);
            }
            else
                return false;
            
            count.put(n, 1);
        }
        return true;
    }
}

// Time and Space Complexity: O(n)
