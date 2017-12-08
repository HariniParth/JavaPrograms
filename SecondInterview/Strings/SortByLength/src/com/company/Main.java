package com.company;

import java.util.*;

public class Main {

    public void sortByLength(String[] s){

        Arrays.sort(s, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });

        Arrays.sort(s, Comparator.comparingInt(String::length));
    }
}
