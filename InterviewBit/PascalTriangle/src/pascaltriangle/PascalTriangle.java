/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascaltriangle;

import java.util.*;

/**
 *
 * @author harini-geek
 */
public class PascalTriangle {

    public ArrayList<ArrayList<Integer>> pascalTriangle(int a){
        
        int rows = a;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if(a == 0)
            return res;
        
        res.get(0).add(1);
        for(int i=1;i<rows;i++){
            res.get(i).add(1);
            for(int j=0;j<i-1;j++){
                int num = res.get(i-1).get(j) + res.get(i-1).get(j+1);
                res.get(i).add(num);
            }
            res.get(i).add(1);
        }
        return res;        
    }
    
}
