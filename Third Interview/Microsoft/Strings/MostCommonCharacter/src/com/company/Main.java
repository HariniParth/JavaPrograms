package com.company;

public class Main {

    static final int max = 256;

    private char mostCommon(String s){

        int[] count = new int[max];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }

        int max = 0;
        char res = ' ';
        for(int i=0;i<s.length();i++){
            if(max < count[s.charAt(i)]){
                max = count[s.charAt(i)];
                res = s.charAt(i);
            }
        }
        return res;
    }
}