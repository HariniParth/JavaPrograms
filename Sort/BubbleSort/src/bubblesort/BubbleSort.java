/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.io.*;

/**
 *
 * @author harini-geek
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
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
        
        int i,j,lt = n-1, temp;
        boolean flag = false;
        for(i=0;i<lt;i++){
            for(j=0;j<lt-i;j++){
                if(a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(flag == false)
                break;
            else flag = false;
        }
        
        System.out.println("Sorted elements ");
        for(i=0;i<n;i++){
            System.out.println(a[i]);
        }
    }
    
}
