package com.company;

public class Main {

    public int palindromicSubstring(String s){

        int n = s.length();
        int maxLength = 1;
        int start = 0;
        int low, high;

        for(int i=1;i<n;++i){
            low = i-1;
            high = i;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > maxLength){
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            low = i-1;
            high = i+1;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > maxLength){
                    start = low;
                    maxLength = high - low + 1;
                }
            }
        }

        System.out.println("Palindromic substring: "+s.substring(start, start+maxLength-1));

        return maxLength;
    }
}
