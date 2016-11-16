/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missingnumber;

/**
 *
 * @author harini-geek
 */
public class MissingNumber {

    /**
     * @param args the command line arguments
     */
    private static int sumOfNumbers(int n){
        return (n*(n+1)/2);
    }
    
    private static int sumOfElements(int a[]){
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {1,2,3,5,6};
        int n = 6;
        System.out.println("Missing Number "+(sumOfNumbers(n) - sumOfElements(a)));
    }
    
}
