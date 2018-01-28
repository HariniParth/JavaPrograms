/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitarraylargestsum;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/split-array-largest-sum/
 */

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int split){
        long l = 0;
        long r = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            r += nums[i];
            if(l < nums[i])
                l = nums[i];
        }
        
        long result = 0;
        while(l <= r){
            long mid = (l + r) >> 1;
            long sum = 0;
            int count = 1;
            for(int i=0;i<n;i++){
                if(sum + nums[i] > mid){
                    count++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if(count <= split){
                result = Math.min(result, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return (int) result;
    }
}
