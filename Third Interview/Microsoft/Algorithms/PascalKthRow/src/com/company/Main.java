package com.company;

import java.util.*;

public class Main {

    public ArrayList<Integer> pascalKthRow(int k){

        if(k == 0)
            return null;

        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);

        for(int i=0;i<k;i++){
            int val;
            int last = 0;
            for(int j=0;j<i+1;j++){
                val = result.get(j);
                if(j-1 >= 0)
                    val += last;
                last = result.get(j);
                result.set(i, val);
            }
            result.add(result.get(0));
        }
        return result;
    }
}