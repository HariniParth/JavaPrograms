/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lengthoflastword;

/**
 *
 * @author harini-geek
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(final String A) {
        int i;

        if(A.length() == 0)
            return 0;

        int n = A.length();
        int lastWordIndex = n;
        int endIndex = n;
        i = n - 1;

        while(i >= 0 && A.charAt(i) == ' ')
            i--;
        endIndex = i;

        for (; i >= 0; i--) {
            if (A.charAt(i) == ' ') {
                break;
            }
            lastWordIndex = i;	        
        }
        return Math.max(0, endIndex - lastWordIndex + 1);
    }
}
