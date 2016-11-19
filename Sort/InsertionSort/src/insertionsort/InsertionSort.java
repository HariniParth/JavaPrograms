/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsort;

import java.io.*;

/**
 *
 * @author harini-geek
 */
public class InsertionSort {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of the array");
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        
        for(int i=0;i<n;i++){
            System.out.println("Enter next element");
            a[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=1;i<n;i++){
            int key = a[i];
            int j = i-1;
            
            while(j>=0 && a[j]>key){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
        
        System.out.println("Sorted array");
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
    }
    
}
