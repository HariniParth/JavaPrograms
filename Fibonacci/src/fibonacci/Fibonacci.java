/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.io.*;

/**
 *
 * @author harini-geek
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Range: ");
        int n = Integer.parseInt(br.readLine());
        int a = 0, b = 1, count = 2, c;
        System.out.println(a);
        System.out.println(b);
        while(count <= n){
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
            count++;
        }
    }
    
}
