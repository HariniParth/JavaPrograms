/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagrams;

import java.util.*;

/**
 *
 * @author harini-geek
 */
public class Anagrams {

    /**
     * @param s1
     * @param s2
     */
    
    public void anagrams(String s1, String s2){
        
        if(s1.length() != s2.length()){
            System.out.println("Not Anagrams");
        } else {
            char string1[] = s1.toLowerCase().toCharArray();
            char string2[] = s2.toLowerCase().toCharArray();
            
            Arrays.sort(string1);
            Arrays.sort(string2);
            
            if(Arrays.equals(string1, string2)){
                System.out.println("Anagrams");
            } else {
                System.out.println("Not Anagrams");
            }
        }
    }
    
    public static void main(String[] args) {
        
        String s1 = "Geeks", s2 = "skeeG";
        
        Anagrams grams = new Anagrams();
        grams.anagrams(s1, s2);
    }
    
}
