/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergeintervals;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/merge-intervals/
 */

public class MergeIntervals {

    private class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval i1, Interval i2){
            return i1.start < i2.start? -1 : i1.start == i2.start? 0 : 1;
        }
        
        public List<Interval> merged(List<Interval> intervals){
            Collections.sort(intervals, new IntervalComparator());
            
            LinkedList<Interval> merged = new LinkedList<>();
            
            for(Interval interval : intervals){
                if(merged.size() == 0 || merged.getLast().end < interval.start)
                    merged.add(interval);
                else
                    merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
            
            return merged;
        }
    }
}

// Complexity: O(nlog(n))