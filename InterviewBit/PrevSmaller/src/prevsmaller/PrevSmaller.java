/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prevsmaller;

import java.util.*;

/**
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
Input : A : [4, 5, 2, 10]
Return : [-1, 4, -1, 2]
 */

public class PrevSmaller {

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr){
        
        ArrayList<Integer> prevSmall = new ArrayList<>();
        int n = arr.size();
        if(n == 0)
            return null;
        
        prevSmall.add(-1);
        
        for(int i=1;i<n;i++){
            int j = i-1;
            while(j >= 0){
                if(arr.get(i) > arr.get(j)){
                    prevSmall.add(arr.get(j));
                    break;
                } else
                    j--;
                
                if(j == 0)
                    prevSmall.add(-1);
            }
        }
        
        return prevSmall;
    }    
}
