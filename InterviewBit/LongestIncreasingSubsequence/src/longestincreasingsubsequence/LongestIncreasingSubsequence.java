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

    public int lis(List<Integer> list){
        if(list == null)
            return 0;
        
        int n = list.size();
        if(n == 0)
            return 0;
        
        int[] count = new int[n];
        Arrays.fill(count, 1);
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(list.get(i) > list.get(j) && count[i] <= count[j])
                    count[i] = count[j] + 1;
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res = Math.max(res, count[i]);
        }
        return res;
    }
    
}
