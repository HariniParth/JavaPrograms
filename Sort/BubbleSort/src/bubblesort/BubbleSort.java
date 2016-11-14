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
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of the array");
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        
        //Accept input data
        System.out.println("Enter "+n+" digits - 1 in a line");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        
        int limit = n-1, temp;
        boolean flag = false;
        
        for(int i=0;i<limit;i++){
            for(int j=0;j<limit-i;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag = true; //Sorted
                }
            }
            if(flag == false)
                break;
            else
                flag = false;
        }
        
        System.out.println("Sorted Array");
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
    
}
