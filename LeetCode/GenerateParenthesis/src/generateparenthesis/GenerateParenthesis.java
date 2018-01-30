/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateparenthesis;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/generate-parentheses/
 */

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n){
        List<String> ans = new ArrayList<>();
        if(n == 0)
            ans.add("");
        else {
            for(int i=0;i<n;i++)
                for(String left : generateParenthesis(i))
                    for(String right : generateParenthesis(n-1-i))
                        ans.add("("+left+")"+right);
        }
        return ans;
    }
}

// Time and Space Complexity: 4^n/sqrt(n)