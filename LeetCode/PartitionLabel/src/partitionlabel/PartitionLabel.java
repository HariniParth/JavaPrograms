/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partitionlabel;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/partition-labels/
 * Complexity: O(n)
 */

public class PartitionLabel {

    public List<Integer> partitionLabel(String s){
        int[] last = new int[26];
        for(int i=0;i<s.length();i++)
            last[s.charAt(i) - 'a'] = i;
        
        List<Integer> ans = new ArrayList<>();
        int j = 0, anchor = 0;
        for(int i=0;i<s.length();i++){
            j = Math.max(j, last[s.charAt(i) - 'a']);
            if(i == j){
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
