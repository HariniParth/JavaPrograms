/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climbstairs;

/**
 *
 * @author harini-geek
 */
public class ClimbStairs {

    public int ways(int n){
        
        int [] ways = new int[n+1];
        ways[1] = 1;
        ways[2] = 2;
        for(int i=3;i<=n;i++){
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }
    
}
