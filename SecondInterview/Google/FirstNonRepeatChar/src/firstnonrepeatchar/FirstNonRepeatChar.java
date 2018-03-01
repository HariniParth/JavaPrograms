/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstnonrepeatchar;

/**
 *
 * @author harini-geek
 * https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
 */

public class FirstNonRepeatChar {

    static final int MAX_CHARS = 256;
    static final int[] count = new int[MAX_CHARS];
    
    static void getCharCountArray(String str){
        for(int i=0;i<str.length();i++)
            count[str.charAt(i)]++;
    }
    
    static int firstNonRepeatChar(String str){
        getCharCountArray(str);
        int index = -1, i;
        for(i=0;i<str.length();i++){
            if(count[str.charAt(i)] == 1){
                index = i;
                break;
            }
        }
        return index;
    }
    
}
