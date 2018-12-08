package com.company;

public class Main {

    private int maxConsecutiveChars(String s){

        int n = s.length();
        int count = 0;

        for(int i=0;i<n-1;i++){
            int maxCount = 0;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i) != s.charAt(j))
                    break;

                maxCount++;
            }
            count = Math.max(count, maxCount);
        }
        return count;
    }
}