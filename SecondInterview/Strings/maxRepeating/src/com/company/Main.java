package com.company;

public class Main {

    public int maxConsecutiveChar(String s){

        int n = s.length();
        int count = 0;

        for(int i=0;i<n-1;i++){
            int maxCount = 0;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i) != s.charAt(j))
                    break;

                maxCount++;
            }

            if(maxCount > count)
                count = maxCount;
        }

        return count;
    }
}
