/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation;

import java.util.List;

/**
 *
 * @author harini-geek
 */
public class GasStation {

    public int canCompleteCircuit(List<Integer> gasPrice, List<Integer> costToReach){
        int gas = 0;
        int firstPosition = 0;
        int lastPosition = 0;
        int n = gasPrice.size();
        
        for(int i=0;i<n;i++){
            gas += gasPrice.get(i);
            gas -= costToReach.get(i);
            lastPosition = Math.max(gas, gasPrice.get(i) - costToReach.get(i) + lastPosition);
            if(lastPosition >= 0){
                if(firstPosition == -1)
                    firstPosition = i;
            } else {
                firstPosition = -1;
            }
            lastPosition = Math.max(0, lastPosition);
        }
        if(gas < 0)
            return 0;
        
        return firstPosition;
    }
    
}
