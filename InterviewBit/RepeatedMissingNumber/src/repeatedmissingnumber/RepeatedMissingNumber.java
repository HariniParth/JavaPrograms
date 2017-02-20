/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repeatedmissingnumber;

import java.util.ArrayList;

/**
 *
 * @author harini-geek
 */
public class RepeatedMissingNumber {

    public ArrayList<Integer> number(ArrayList<Integer> list){
        
        ArrayList<Integer> numbers = new ArrayList<>();
        int sum = 0;
        int rep = 0;
        int n = list.size();
        
        for(int i=1;i<n;i++){
            if(list.get(i) == list.get(i-1).intValue())
                rep = list.get(i);
            sum += list.get(i);
        }
        
        int miss = (int)((1L * n * 1L * n + 1)/2 - sum + rep);
        
        numbers.add(rep);
        numbers.add(miss);
        
        return numbers;
    }
    
}
