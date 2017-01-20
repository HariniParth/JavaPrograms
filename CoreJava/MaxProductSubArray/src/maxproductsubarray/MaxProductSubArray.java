/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxproductsubarray;

import java.util.List;

/**
 *
 * @author harini-geek
 */
public class MaxProductSubArray {

    public int maxProduct(List<Integer> a) {
        int max = 0, maxHere = 0;
        for(int i=0;i<(a.size()-1);i++){
            max = Math.max(max,maxHere = a.get(i)*a.get(i+1) > maxHere ? a.get(i)*a.get(i+1) : maxHere);
        }
        return max;
    }
    
}
