package com.company;

public class Main {

    public boolean palindrome(String s){

        int n = s.length();
        if(n == 0)
            return true;


    }

    public boolean recurse(String s, int start, int end){

        if(start == end)
            return true;

        if(s.charAt(start) != s.charAt(end))
            return false;

        if(start < end+1)
            recurse(s, start+1, end-1);

        return true;
    }
}
