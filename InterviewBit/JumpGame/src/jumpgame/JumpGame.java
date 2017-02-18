/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpgame;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author harini-geek
 */
public class JumpGame {

    public int canJump(List<Integer> steps){
        int n;
        int [] step;
        
        n = steps.size();
        step = new int[n];
        Arrays.fill(step, -1);
        step[0] = steps.get(0);
        
        for(int i=1;i<n;i++){
            if(step[i-1] >= i)
                step[i] = Math.max(step[i-1], i+steps.get(i));
        }
        
        for(int i=1;i<n;i++){
            if(step[i] >= n-1)
                return 1;
        }
        return 0;
    }
}
