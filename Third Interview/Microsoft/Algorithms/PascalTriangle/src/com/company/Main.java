package com.company;

import java.util.*;

public class Main {

    public ArrayList<ArrayList<Integer>> pascalTriangle(int k){

        if(k == 0)
            return null;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.get(0).add(1);

        for(int i=1;i<k;i++){
            result.get(i).add(1);
            for(int j=0;j<i-1;j++){
                int num = result.get(i-1).get(j) + result.get(i-1).get(j+1);
                result.get(i).add(num);
            }
            result.get(i).add(1);
        }

        return result;
    }
}
