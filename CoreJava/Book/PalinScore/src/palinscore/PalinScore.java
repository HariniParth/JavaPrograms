/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palinscore;

import java.util.*;

/**
 *
 * @author harini-geek
 */
public class PalinScore {

    public static int score(String word){
        int score = 0;
        if(word == null)
            return 0;
        
        int i, j = word.length() - 1;
        for(i=0;i<j;i++,j--){
            if(word.charAt(i) != word.charAt(j))
                score += 2;
        }        
        
        return score;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");        
        String word = sc.next();
        int score = score(word);
        System.out.println("\nPalindrome score: "+score);
    }
    
}
