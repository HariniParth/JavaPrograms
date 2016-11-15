/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutation;

import java.io.*;

/**
 *
 * @author harini-geek
 */
public class Permutation {

    public static void permute(String begin, String end){
        if(end.length() <= 1){
            System.out.println(begin+end);
        } else {
            try {
                for(int i=0;i<end.length();i++){
                    String newString = end.substring(0, i) + end.substring(i+1);
                    permute(begin + end.charAt(i),newString);
                }
            } catch(StringIndexOutOfBoundsException exception){
                
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a String");
        String s = br.readLine();
        permute("",s);
    }
    
}
