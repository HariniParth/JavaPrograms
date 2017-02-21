/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsets;

import java.util.ArrayList;

/**
 *
 * @author harini-geek
 */
public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(int[] arr){
        
        if(arr.length == 0)
            return null;
        int n = arr.length;
        
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            
            for(ArrayList<Integer> a : results){
                temp.add(new ArrayList<>(a));
            }
            for(ArrayList<Integer> a : temp){
                a.add(arr[i]);
            }
            ArrayList<Integer> single = new ArrayList<>();
            single.add(arr[i]);
            temp.add(single);
            results.addAll(temp);
        }        
        results.add(new ArrayList<Integer>());
        return results;
    }
    
}
