/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestnumbertwiceofothers;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/largest-number-at-least-twice-of-others/
 */

public class LargestNumberTwiceOfOthers {

    public int dominantIndex(int[] arr){
        int maxIndex = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] > arr[maxIndex])
                maxIndex = i;
        }
        
        for(int i=0;i<arr.length;i++){
            if(maxIndex != i && arr[maxIndex] < 2 * arr[i])
                return -1;
        }
        
        return maxIndex;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
