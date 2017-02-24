/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squareroot;

/**
 *
 * @author harini-geek
 */
public class SquareRoot {

    public int sqrt(int n){
        
        int low, high, mid, root, num;
        low = 1;
        high = n;
        root = 0;
        
        while(low <= high){
            mid = (low + high)/2;
            
            if(mid == n/mid && n%mid == 0)
                return mid;
            
            if(mid < n/mid){
                root = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return root;
    }
    
}
