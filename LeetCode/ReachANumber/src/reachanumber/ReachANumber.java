/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reachanumber;

/**
 *
 * @author harini-geek
 */
public class ReachANumber {

    public int reach(int target){
        target = Math.abs(target);
        int k = 0;
        
        while(target > 0)
            target -= ++k;
        
        return (target % 2 == 0)? k : k + 1 + k%2;
    }
    
}
