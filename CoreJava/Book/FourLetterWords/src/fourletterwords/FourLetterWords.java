/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourletterwords;

import java.util.*;

/**
 *
 * @author harini-geek
 */
public class FourLetterWords {

    public static int fourLetterWords(String sentence){
        int count = 0;
        Scanner sc = new Scanner(sentence);
        while(sc.hasNext()){
            String word = sc.next();
            if(word.endsWith(",") || word.endsWith(";") || word.endsWith("."))
                word = word.substring(0,word.length()-1);
            if(word.length() == 4)
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        
        System.out.print("Enter a sentence: ");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        int count = fourLetterWords(sentence);
        System.out.println("\nCount of 4 letter words: "+count);
    }
    
}
