/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsubstring;

import java.io.*;
import java.util.*;

/**
 *
 * @author harini-geek
 */
public class LongestSubString {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a String");
        String s = br.readLine();
        char [] inputArray = s.toCharArray();
        
        String longestSubString = "";
        int subStringLength = 0;
        LinkedHashMap<Character,Integer> subString = new LinkedHashMap<>();
        
        for(int i=0;i<inputArray.length;i++){
            
            if(!subString.containsKey(inputArray[i])){
                subString.put(inputArray[i], i);
            } else {
                i = subString.get(inputArray[i]);
                subString.clear();
            }
            
            if(subString.size() > subStringLength){
                subStringLength = subString.size();
                longestSubString = subString.keySet().toString();
            }
        }
        
        System.out.println("Longest Substring "+longestSubString);
        System.out.println("Longest Substring length "+subStringLength);
    }
    
}
