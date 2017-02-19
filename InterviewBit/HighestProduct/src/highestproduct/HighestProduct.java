/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highestproduct;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author harini-geek
 */
public class HighestProduct {

    public int highestProduct(List<Integer> list){
        if(list == null)
            return 0;
        int n = list.size();
        if(n == 0)
            return 0;
        Collections.sort(list);
        
        return list.get(n-1) * list.get(n-2) * list.get(n-3);
    }    
}
