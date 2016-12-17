/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

import java.io.*;

/**
 *
 * @author harini-geek
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of the array");
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        
        for(int i=0;i<n;i++){
            System.out.println("Enter next element");
            a[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=0;i<n-1;i++){
            int min_index = i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[min_index]){
                    min_index = j;
                }
            }
            
            int temp = a[min_index];
            a[min_index] = a[i];
            a[i] = temp;
        }
        
        System.out.println("Sorted array");
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
    }
    
}
