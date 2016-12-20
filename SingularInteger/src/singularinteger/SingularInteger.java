/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singularinteger;

import java.io.*;
import java.util.*;

/**
 *
 * @author harini-geek
 */
public class SingularInteger {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of array");
        int size = Integer.parseInt(br.readLine());
        int intArray[] = new int[size];
        
        for(int i=0;i<size;i++){
            System.out.println("Enter integer");
            intArray[i] = Integer.parseInt(br.readLine());
        }
        
        HashSet<Integer> singular = new HashSet<>();
        for(int num : intArray){
            if(!singular.contains(num)){
                singular.add(num);
            } else {
                singular.remove(num);
            }
        }
        
        System.out.print("Singular elements");
        
        Iterator it = singular.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        
    }
    
}
