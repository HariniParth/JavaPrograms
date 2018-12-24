package com.company;

import java.util.*;

// https://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-and-answers.html

public class Main {

    private int missingNumber(int[] arr, int num){

        int expectedTotal = (num * (num+1))/2;
        int actualTotal = 0;
        for(int i=0;i<arr.length;i++){
            actualTotal += arr[i];
        }
        return expectedTotal - actualTotal;
    }

    private int duplicateNumber(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+1);
            else
                map.put(arr[i], 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1)
                return entry.getKey();
        }
        return -1;
    }

    private boolean containsNumber(int[] arr, int low, int high, int num){

        if(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == num)
                return true;
            if(arr[mid] > num)
                return containsNumber(arr, low, mid-1, num);

            return containsNumber(arr, mid+1, high, num);
        }
        return false;
    }

    private ArrayList<Integer> extremeNumbers(int[] arr){

        ArrayList<Integer> numbers = new ArrayList<>();
        int smallest = -1;
        int largest = -1;
        for(int i=0;i<arr.length;i++){
            smallest = Math.min(smallest, arr[i]);
            largest = Math.max(largest, arr[i]);
        }
        numbers.add(smallest);
        numbers.add(largest);
        return numbers;
    }

    private void printPairsWithSum(int[] arr, int sum){

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] + arr[j] == sum)
                    System.out.println(arr[i]+" "+arr[j]);
            }
        }
    }

    private int[] removeDuplicates(int[] arr){

        Arrays.sort(arr);
        int n = arr.length;
        int[] result = new int[n];
        int previous = arr[0];
        result[0] = previous;

        for(int i=1;i<n;i++){
            int element = arr[i];
            if(element != previous)
                result[i] = element;
            previous = element;
        }
        return result;
    }

    private int quickSort(int[] arr, int low, int high){

        int pivot = arr[high];
        int i = low-1;
        for(int j=low;j<high;j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    private void printIntersection(int[] arr1, int[] arr2){

        int m = arr1.length;
        int n = arr2.length;
        int i = 0, j = 0;
        while(i < m && j < n){
            if(arr1[i] < arr2[j])
                i++;
            else if(arr1[i] > arr2[j])
                j++;
            else {
                System.out.print(arr1[i++]);
                j++;
            }
        }
    }

    private int KthLargestElement(Integer[] arr, int k){

        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for(int i : arr){
            queue.offer(i);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    /*
    We can use a min heap to solve this problem. The heap stores the top k elements.
    Whenever the size is greater than k, delete the min.
    Time complexity is O(nlog(k)). Space complexity is O(k) for storing the top k numbers.
     */

    private void commonInThree(int[] arr1, int[] arr2, int[] arr3){

        int i = 0, j = 0, k = 0;
        while(i < arr1.length && j < arr2.length && k < arr3.length){
            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                System.out.print(arr1[i]);
                i++;
                j++;
                k++;
            }
            if(arr1[i] < arr2[j])
                i++;
            else if(arr2[j] < arr3[k])
                j++;
            else
                k++;
        }
    }

    private int firstNonRepeatingElement(int[] arr){

        int n = arr.length;
        for(int i=0;i<n;i++){
            int j;
            for(j=0;j<n;j++){
                if(i != j && arr[i] == arr[j])
                    break;
            }
            if(j == n)
                return arr[i];
        }
        return -1;
    }

    private void maxTwoNumbers(int[] arr){

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max1){
                max2 = max1;
                max1 = arr[i];
            }
            else if(arr[i] > max2){
                max2 = arr[i];
            }
        }
        System.out.print("1: "+max1+" 2: "+max2);
    }

    /*
     https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/
     Find the smallest positive integer value that cannot be represented as sum of any subset of a given array
      */

    private int smallestSum(int[] arr){

        int res = 1;
        int n = arr.length;
        for(int i=0;i<n && arr[i] < res;i++){
            res = res + arr[i];
        }
        return res;
    }

    // https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/

    private void rearrangePosNeg(int[] arr){

        int i = -1, temp = 0;
        int n = arr.length;
        for(int j=0;j<n;j++){
            if(arr[j] < 0){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int pos = i+1, neg = 0;
        while(pos < n && neg < pos && arr[neg] < 0){
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
    }

    // https://www.geeksforgeeks.org/delete-an-element-from-array-using-two-traversals-and-one-traversal/

    private void deleteElement(int[] arr, int num){

        int n = arr.length, i;
        for(i=0;i<n;i++)
            if(arr[i] == num)
                break;

        if(i < n){
            n = n - 1;
            for(int j=i;j<n;j++)
                arr[j] = arr[j+1];
        }
    }

    private int maxSumSubArray(int[] arr){

        int n = arr.length;
        int max = Integer.MIN_VALUE, maxHere = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            maxHere = Math.max(maxHere+arr[i], arr[i]);
            max = Math.max(max, maxHere);
        }
        return max;
    }

    // https://www.programcreek.com/2014/03/leetcode-maximum-product-subarray-java/

    private int largestProduct(int[] arr){

        int n = arr.length;
        int[] max = new int[n];
        int[] min = new int[n];

        max[0] = min[0] = arr[0];
        int result = arr[0];

        for(int i=1;i<n;i++){
            if(arr[i] > 0){
                max[i] = Math.max(arr[i], max[i-1] * arr[i]);
                min[i] = Math.min(arr[i], min[i-1] * arr[i]);
            } else {
                max[i] = Math.max(arr[i], min[i-1] * arr[i]);
                min[i] = Math.min(arr[i], max[i-1] * arr[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }

    // https://www.geeksforgeeks.org/longest-consecutive-subsequence/

    private int longestConsSubSeqLen(int[] arr){

        HashSet<Integer> set = new HashSet<>();
        int n = arr.length;
        int res = 0;

        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        for(int i=0;i<n;i++){
            if(!set.contains(arr[i] - 1)){
                int num = arr[i];
                while(set.contains(num))
                    num++;
                if(res < num - arr[i])
                    res = num - arr[i];
            }
        }
        return res;
    }

    // https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/

    private int minRotatedArray(int[] arr, int low, int high){

        if(high < low)
            return arr[0];
        if(high == low)
            return arr[low];
        int mid = low + (high - low)/2;
        if(mid < high && arr[mid] > arr[mid+1])
            return arr[mid+1];
        if(mid > low && arr[mid] < arr[mid-1])
            return arr[mid];
        if(arr[high] > arr[mid])
            return minRotatedArray(arr, low, mid-1);

        return minRotatedArray(arr, mid+1, high);
    }

    private void reverse(int[] arr){

        int n = arr.length;
        for(int i=0;i<n/2;i++){
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }
    }
}
