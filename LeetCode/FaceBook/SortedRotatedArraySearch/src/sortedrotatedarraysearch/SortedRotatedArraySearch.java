/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortedrotatedarraysearch;

/**
 *
 * @author harini-geek
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */

public class SortedRotatedArraySearch {

    public int pivotedBinarySearch(int[] arr, int n, int key){
        int pivot = pivot(arr, 0, n);
        if(pivot == -1)
            return binarySearch(arr, 0, n-1, key);
        
        if(arr[pivot] == key)
            return pivot;
        if(arr[0] <= key)
            return binarySearch(arr, 0, pivot-1, key);
        
        return binarySearch(arr, pivot+1, n-1, key);
    }
    
    public int pivot(int[] arr, int low, int high){
        if(high < low)
            return -1;
        if(high == low)
            return low;
        
        int mid = (low + high)/2;
        if(mid < high && arr[mid] > arr[mid+1])
            return mid;
        if(mid > low && arr[mid] < arr[mid-1])
            return (mid-1);
        if(arr[low] >= arr[mid])
            return pivot(arr, low, mid-1);
        
        return pivot(arr, mid+1, high);
    }
    
    public int binarySearch(int[] arr, int low, int high, int key){
        if(high < low)
            return -1;
        
        int mid = (low + high)/2;
        if(key == arr[mid])
            return mid;
        if(key < arr[mid])
            return binarySearch(arr, low, mid-1, key);
        else
            return binarySearch(arr, mid+1, high, key);
    }
}
