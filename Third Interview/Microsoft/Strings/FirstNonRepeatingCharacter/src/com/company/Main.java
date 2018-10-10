package com.company;

public class Main {

    static final int max = 256;

    private int firstNonRepeatingCharacter(String s){

        int[] count = new int[max];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }

        int index = -1;
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)] == 1){
                index = i;
                break;
            }
        }
        return index;
    }
}