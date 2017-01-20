/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyandsell1;

import java.util.List;

/**
 *
 * @author harini-geek
 */
public class BuyAndSell1 {

    public int stocks(List<Integer> a) {
        int max = 0, maxHere = 0;
        for(int i=0;i<a.size()-1;i++){
            for(int j=i+1;j<a.size();j++){
                maxHere = Math.max(maxHere, a.get(j)-a.get(i));
            }
            max = Math.max(max, maxHere);
        }
        return max;
    }
    
}
