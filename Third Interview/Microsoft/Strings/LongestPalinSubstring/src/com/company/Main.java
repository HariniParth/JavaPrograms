package com.company;

// https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/

public class Main {

    public int longestPalinSubstring(String s){

        int n = s.length();
        int maxLength = 1;
        int start = 0;
        int low, high;

        for(int i=1;i<n;i++){
            low = i-1;
            high = i;

            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                if(high-low+1 > maxLength){
                    maxLength = high-low+1;
                    start = low;
                }
                --low;
                ++high;
            }

            low = i-1;
            high = i+1;

            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                if(high-low+1 > maxLength){
                    maxLength = high-low+1;
                    start = low;
                }
                --low;
                ++high;
            }
        }

        System.out.print("Longest palindromic substring: "+s.substring(start, start+maxLength-1));
        return maxLength;
    }
}
