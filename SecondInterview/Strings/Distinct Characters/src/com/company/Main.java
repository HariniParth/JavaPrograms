package com.company;

public class Main {

   static final int max_char = 256;

   public void distinctCharacter(String s){

       int[] count = new int[max_char];

       int i;
       for(i=0;i<s.length();i++){
           if(count[s.charAt(i)] != ' ')
               count[(int) s.charAt(i)]++;
       }

       int n = i;
       for(i=0;i<n;i++){
           if(count[(int) s.charAt(i)] == 1)
               System.out.println(s.charAt(i));
       }
   }
}
