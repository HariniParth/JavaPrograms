/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equalsubsetsum;

/**
 *
 * @author harini-geek
 */
public class EqualSubsetSum {

    private boolean equalSubsetSum(int[] array, int n, int sum){
        if(sum == 0)
            return true;
        if(n == 0 && sum != 0)
            return false;
        
        if(array[n-1] > sum)
            equalSubsetSum(array, n-1, sum);
        
        return equalSubsetSum(array, n-1, sum) || equalSubsetSum(array, n-1, sum-array[n-1]);
    }
    
    private boolean isSumEven(int[] array, int n){
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += array[i];
        }
        if(sum%2 == 0)
            equalSubsetSum(array, n, sum);
        return false;
    }
    
    public void solution(int[] array){
        int n = array.length;
        if(isSumEven(array, n))
            System.out.println("Subset possible");
        else
            System.out.println("Subset not possible");
    }
    
}
