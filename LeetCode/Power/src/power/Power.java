/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package power;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/powx-n/
 */
public class Power {

    public double power(double x, int n){
        long N = n;
        if(n < 0){
            x = 1/x;
            N = -N;
        }
        
        double result = 1;
        double curr_product = x;
        
        for(long i=N;i>0;i/=2){
            if(i%2 == 1)
                result = result * curr_product;
            curr_product *= curr_product;
        }
        
        return result;
    }
}

// Complexity: O(log(n))