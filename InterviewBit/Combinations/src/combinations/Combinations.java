/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinations;

import java.util.ArrayList;

/**
 *
 * @author harini-geek
 */
public class Combinations {

    ArrayList<ArrayList<Integer>> result;
    
    public ArrayList<ArrayList<Integer>> combinations(int n, int k){
        
        result = new ArrayList<>();
        if(k < n)
            return result;
        rec(n, 0, k, new ArrayList<Integer>());
        return result;        
    }
    
    public void rec(int n, int last, int k, ArrayList<Integer> temp){
        if(k == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=last+1;i<=n;i++){
            temp.add(i);
            rec(n, i, k-1, temp);
            temp.remove(temp.size()-1);
        }
    }
    
}
