/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagramsmapping;

import java.util.*;
/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/find-anagram-mappings/
 * Complexity: O(n)
 */

public class AnagramsMapping {

    public int[] anagramMapping(int[] a, int[] b){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<b.length;i++)
            map.put(b[i], i);
        
        int[] ans = new int[a.length];
        int t = 0;
        for(int i : a)
            ans[t++] = map.get(i);
        
        return ans;
    }
}
