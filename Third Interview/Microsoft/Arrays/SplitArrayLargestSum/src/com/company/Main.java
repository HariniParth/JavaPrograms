package com.company;

// http://shirleyisnotageek.blogspot.com/2016/10/split-array-largest-sum.html

public class Main {

    private int numSplits(int[] arr, int numSplits){

        if(arr.length == 0)
            return 0;

        int left = 0, right = 0;
        for(int num : arr){
            left = Math.max(left, num);
            right += num;
        }

        if(numSplits == arr.length)
            return left;
        if(numSplits == 1)
            return right;

        while(left < right){
            int mid = (left+right)/2;
            if(canSplit(arr, mid, numSplits)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canSplit(int[] arr, int maxVal, int numSplits){

        int countSplits = 1;
        int currSum = 0;
        for(int num : arr){
            currSum += num;
            if(currSum > maxVal){
                currSum = maxVal;
                countSplits++;
                if(countSplits > numSplits)
                    return false;
            }
        }
        return true;
    }
}