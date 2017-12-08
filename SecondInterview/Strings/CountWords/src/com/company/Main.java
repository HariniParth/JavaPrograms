package com.company;

public class Main {

    static final int out = 0;
    static final int in = 1;

    public int wordCount(String s){

        int state = out;
        int n = s.length();
        int wc = 0;
        int i = 0;

        while(i < n){
            if(s.charAt(i) == ' ' || s.charAt(i) == '\t' || s.charAt(i) == '\n')
                state = out;

            else if(state == out){
                state = in;
                ++wc;
            }

            ++i;
        }

        return wc;
    }
}
