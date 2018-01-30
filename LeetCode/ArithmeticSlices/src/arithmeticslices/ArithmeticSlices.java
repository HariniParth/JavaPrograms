/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmeticslices;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/arithmetic-slices-ii-subsequence/
 */

public class ArithmeticSlices {

    public int arithmeticSlices(int[] A){
        int n = A.length;
        long ans = 0;
        Map<Integer, Integer>[] map = new Map[n];
        
        for(int i=0;i<n;i++){
            map[i] = new HashMap<>(i);
            for(int j=0;j<i;j++){
                long delta = (long) A[i] - (long) A[j];
                if(delta <= Integer.MIN_VALUE || delta >= Integer.MAX_VALUE)
                    continue;
                int diff = (int) delta;
                int sum = (map[j].get(diff) != null)? map[j].get(diff):0;
                int origin = (map[i].get(diff) != null)? map[i].get(diff):0;
                map[i].put(diff, sum + origin + 1);
                ans += sum;
            }
        }
        return (int) ans;
    }
    
}
