package com.company;

public class Main {

    static final int max_char = 256;

    public void commonCharacters(String s1, String s2){

        int[] a1 = new int[max_char];
        int[] a2 = new int[max_char];

        int n1 = s1.length();
        int n2 = s2.length();

        for(int i=0;i<n1;i++)
            a1[s1.charAt(i) - 'a']++;

        for(int i=0;i<n2;i++)
            a2[s2.charAt(i) - 'a']++;

        for(int i=0;i<max_char;i++){
            if(a1[i] != 0 && a2[i] != 0){
                for(int j=0;j< Math.min(a1[i], a2[i]);j++){
                    System.out.println((char) i + 'a');
                }
            }
        }
    }
}
