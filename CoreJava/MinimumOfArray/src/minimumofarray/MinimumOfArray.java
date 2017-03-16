/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumofarray;

import java.util.*;

/**
 *
 * @author harini-geek
 */
public class MinimumOfArray {

    public ArrayList<Integer> minimumOfArray(ArrayList<Integer> arr){
        
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.size();
        if(n == 0)
            return null;
        
        for(int i=0;i<n;i++){
            int min = arr.get(i);
            for(int j=i;j<n;j++){
                min = Math.min(min, arr.get(j));
            }
            result.add(min);
        }
        return result;
    }    
}
