/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstnonrepeatchar;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
 */

class charCount{
    int index;
    int count;
    
    charCount(int index){
        this.count = 1;
        this.index = index;
    }
    
    void incrCount(){
        this.count++;
    }
}


public class FirstNonRepeatingChar {
    
    static final int MAX_CHAR = 256;
    static final HashMap<Character, charCount> charCount = new HashMap<>();
    
    static void getCharCount(String str){
        for(int i=0;i<str.length();i++){
            if(charCount.containsKey(str.charAt(i)))
                charCount.get(str.charAt(i)).incrCount();
            else
                charCount.put(str.charAt(i), new charCount(i));
        }
    }
    
    static int getFirstNonRepeating(String str){
        getCharCount(str);
        int result = Integer.MAX_VALUE;
        for(int i=0;i<str.length();i++){
            if(charCount.get(str.charAt(i)).count == 1 && result > charCount.get(str.charAt(i)).index)
                result = charCount.get(str.charAt(i)).index;
        }
        return result;
    }
}
