package com.company;

// https://www.programcreek.com/2014/02/leetcode-reverse-words-in-a-string-java/

public class Main {

    public String reverse(String s){

        if(s == null || s.length() == 0)
            return null;

        int n = s.length();
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=arr.length-1; i>=0; --i){
            if(!arr[i].equals(""))
                sb.append(arr[i]);
        }

        return sb.length() == 0? "" : sb.substring(0, sb.length()-1);
    }
}
