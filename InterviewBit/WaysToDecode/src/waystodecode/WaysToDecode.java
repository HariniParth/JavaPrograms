/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waystodecode;

import java.util.Arrays;


/**
 *
 * @author harini-geek
 */
public class WaysToDecode {

    private String S;
    private int[] count;
    private int N;
    
    public int solution(String S){
        int N = S.length();
        if(S == null)
            return 0;
        count = new int[N];
        Arrays.fill(count, -1);
        return ways(N-1);        
    }
    
    private int ways(int index){
        if(index < 0)
            return 1;
        if(count[index] != -1)
            return count[index];
        
        int ways = 0;
        if(S.charAt(index) > '0')
            ways = ways(index - 1);
        
        if(isValidTwoDigits(index))
            ways += ways(index - 2);
        
        return count[index] = ways;
    }
    
    private boolean isValidTwoDigits(int index){
        if(index > 0 && (S.charAt(index-1) == '1' || S.charAt(index-2) == '2' && S.charAt(index) < '7'))
            return true;
        return false;
    }
    
}
