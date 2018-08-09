package com.company;

/*
    Given string s and string t find whether all permutation of t is present as substring in s
    https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 */

public class Main {

    static final int max = 256;

    private static boolean compare(char[] countP, char[] countT){

        for(int i=0;i<max;i++)
            if(countP[i] != countT[i])
                return false;

        return true;
    }

    public void search(String pattern, String text){

        int m = pattern.length();
        int n = text.length();

        char[] countP = new char[max];
        char[] countT = new char[max];

        for(int i=0;i<m;i++){
            countP[pattern.charAt(i)]++;
            countT[text.charAt(i)]++;
        }

        for(int i=m;i<n;i++){
            if(compare(countP, countT))
                System.out.print("Found at position: "+(i-m));

            countT[text.charAt(i)]++;
            countT[text.charAt(i-m)]++;
        }
        if(compare(countP, countT))
            System.out.print("Found at position: "+(n-m));
    }
}
