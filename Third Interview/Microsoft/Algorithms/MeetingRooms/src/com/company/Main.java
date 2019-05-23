package com.company;

import java.util.*;

// https://www.programcreek.com/2014/05/leetcode-meeting-rooms-ii-java/

public class Main {

    private int meetingRooms(int[][] intervals){

        Arrays.sort(intervals, Comparator.comparing((int[] intv) -> intv[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int count = 0;

        for(int[] intv : intervals){
            if(heap.isEmpty()){
                count++;
                heap.offer(intv[1]);
            } else {
                if(intv[0] >= heap.peek())
                    heap.poll();
                else
                    count++;
                heap.offer(intv[1]);
            }
        }
        return count;
    }
}