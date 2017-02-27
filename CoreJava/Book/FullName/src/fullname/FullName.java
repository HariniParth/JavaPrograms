/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fullname;

import java.io.*;

/**
 *
 * @author harini-geek
 */
public class FullName {

    public static void main(String[] args) throws IOException {
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter First Name");
        String first = br.readLine();
        System.out.println("Enter Middle Name");
        String middle = br.readLine();
        System.out.println("Enter Last Name");
        String last = br.readLine();
        
        sb.append(first);
        sb.append(last);
        int n = first.length();
        sb.insert(n, middle);
        
        System.out.println("Name: "+sb.toString());
        System.out.println("Reverse: "+sb.reverse().toString());
    }
    
}
