/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringreorganization;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/reorganized-string/
 */

public class StringReorganization {

    public String reOrganize(String s){
        int n = s.length();
        int[] count = new int[26];
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            count[c - 'a'] += 100;
        }
        
        for(int i=0;i<26;i++)
            count[i] += i;
        
        Arrays.sort(count);
        
        char[] ans = new char[n];
        int t = 1;
        for(int code : count){
            int ct = code / 100;
            char ch = (char) ('a' + code % 100);
            if(ct > (n + 1)/2)
                return "";
            for(int i=0;i<ct;++i){
                if(t >= n)
                    t = 0;
                ans[t] = ch;
                t += 2;
            }
        }
        
        return String.valueOf(ans);
        
    }
}

// Time and Space Complexity: O(N)
