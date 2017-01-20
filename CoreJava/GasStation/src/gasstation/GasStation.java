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

    public int firstGasStation(List<Integer> gas, List<Integer> cost) {
        int n = gas.size();
        int firstIndex = 0;
        int lastPosition = 0;
        int amountOfPetrol = 0;
        
        for(int i=0;i<n;i++){
            amountOfPetrol += gas.get(i);
            amountOfPetrol -= cost.get(i);
            lastPosition = Math.max(amountOfPetrol, gas.get(i) - cost.get(i) + lastPosition);
            if(lastPosition >= 0){
                if(firstIndex == -1)
                    firstIndex = i;
            } else {
                firstIndex = -1;
            }
            lastPosition = Math.max(0, lastPosition);
        }
        
        if(amountOfPetrol < 0)
            return -1;
        
        return firstIndex;
    }
    
}
