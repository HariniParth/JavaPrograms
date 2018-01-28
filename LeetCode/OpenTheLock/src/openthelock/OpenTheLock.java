/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openthelock;

import java.util.*;

/**
 *
 * @author harini-geek
 * https://leetcode.com/articles/open-the-lock/
 */

public class OpenTheLock {

    public int openLock(String[] deadends, String target){
        HashSet<String> ends = new HashSet<>();
        ends.addAll(Arrays.asList(deadends));
        
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        queue.add(null);
        
        HashSet<String> seen = new HashSet<>();
        seen.add("0000");
        
        int depth = 0;
        while(!queue.isEmpty()){
            String node = queue.poll();
            if(node == null){
                depth++;
                if(queue.peek() != null)
                    queue.offer(null);
            }
            else if(node.equals(target))
                return depth;
            else if(!ends.contains(node)){
                for(int i=0;i<4;i++){
                    for(int d=-1;d<1;d+=2){
                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
                        String nei = node.substring(0, i) + ("" + y) + node.substring(i+1);
                        
                        if(!seen.contains(nei)){
                            seen.add(nei);
                            queue.add(nei);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}

// Time, Space Complexity: O(A^N + D) 
/*
    A is the number of digits in the alphabet, 
    N is the number of digits in the lock,
    D is the size of deadends
*/