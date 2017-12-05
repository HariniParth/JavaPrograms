package com.company;

import java.util.*;

public class Main {

    public ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> list){

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        recurse(result, list, 0);
        return result;
    }

    public void recurse(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, int index){
        if(index == cur.size()-1)
            res.add(new ArrayList<>(cur));

        for(int i=index;i<cur.size();i++){
            Collections.swap(cur, i, index);
            recurse(res, cur, index+1);
            Collections.swap(cur, i, index);
        }
    }
}
