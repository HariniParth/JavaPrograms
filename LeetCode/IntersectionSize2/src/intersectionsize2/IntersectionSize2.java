/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intersectionsize2;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/set-intersection-size-at-least-two/
 */

public class IntersectionSize2 {

    public int intersectionSize2(int[][] intervals){
        
        Arrays.sort(intervals, (a, b) -> a[0] != b[0]? a[0] - b[0] : b[1] - a[1]);
        
        int ans = 0, t = intervals.length;
        int[] todo = new int[t];
        Arrays.fill(todo, 2);
        
        while(--t >= 0){
            int p = intervals[t][0];
            int m = todo[t];
            for(int i=p;i<p+m;++i){
                for(int j=0;j<=t;j++){
                    if(todo[j] > 0 && i <= intervals[j][1])
                        todo[j]--;
                    ans++;
                }
            }
        }
        
        return ans;
    }
}

// Complexity: Time O(n^2) and Space O(n)