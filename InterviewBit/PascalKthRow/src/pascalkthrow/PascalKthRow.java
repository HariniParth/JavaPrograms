/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascalkthrow;

import java.util.*;

/**
 *
 * @author harini-geek
 */
public class PascalKthRow {

    public ArrayList<Integer> getRow(int n){
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        
        for(int i=0;i<n;i++){
            int val;
            int last = 0;
            for(int j=0;j<i+1;j++){
                val = list.get(j);
                if(j-1 >= 0)
                    val += last;
                last = list.get(j);
                list.set(i, val);
            }
            list.add(list.get(0));
        }
        return list;
    }
    
}
