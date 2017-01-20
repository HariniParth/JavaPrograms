/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestincreasingsubsequence;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author harini-geek
 */
public class LongestIncreasingSubsequence {

    public int longest(List<Integer> a) {
        int n = a.size();
        int count[] = new int[n];
        Arrays.fill(count,1);
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(a.get(i) > a.get(j) && count[i] <= count[j])
                    count[i] = count[j] + 1;
            }
        }
        
        int res = 0;
        for(int i=0;i<n;i++)
            res = Math.max(res, count[i]);
        
        return res;
    }
    
}
