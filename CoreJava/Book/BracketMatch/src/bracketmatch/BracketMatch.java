/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bracketmatch;

import java.util.*;

/**
 *
 * @author harini-geek
 */
public class BracketMatch {

    public static int bracketMatch(String S){
        int count = 0, open = 0, close = 0;
        if(S == null)
            return count;
        
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '(')
                open++;
            else if(S.charAt(i) == ')')
                close++;
        }
        
        count = Math.abs(open-close);
        
        return count;
    }
    
    public static void main(String args[]){
        System.out.print("Enter a string: ");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        
        int match = bracketMatch(string);
        System.out.println("Bracket match "+match);
    }
    
}
