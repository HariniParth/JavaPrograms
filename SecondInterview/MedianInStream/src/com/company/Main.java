package com.company;

import java.util.*;

public class Main {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public int[] median(int[] num){

        int count = num.length;
        maxHeap = new PriorityQueue<>(count, Collections.reverseOrder());
        minHeap = new PriorityQueue<>(count);

        int[] ans = new int[count];
        for(int i=0;i<count;i++){
            addNum(num[i]);
            ans[i] = findMedian();
        }

        return ans;
    }

    public void addNum(int n){

        maxHeap.offer(n);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    public int findMedian(){

        if(maxHeap.size() == minHeap.size())
            return maxHeap.peek();
        else
            return (maxHeap.peek() + minHeap.peek())/2;
    }
}
