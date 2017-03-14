/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsubstringlength;

import java.util.*;

/**
 *
 * @author harini-geek
 */
public class LongestSubStringLength {

    public int longestSubStringLength(String S){
        
        int max = 0;
        int count = 0;
        int n = S.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        char ch;
        int prevIndex;
        
        for(int i=0;i<S.length();i++){
            ch = S.charAt(i);
            if(map.containsKey(ch)){
                prevIndex = map.get(S.charAt(i));
                count = Math.min(count+1, i-prevIndex);
                map.put(ch, i);
            } else {
                count++;
                map.put(ch, i);
            }
            max = Math.max(max, count);
        }
        return max;
    }
    
}
