/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miceholemaxmoves;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author harini-geek
 */
public class MiceHoleMaxMoves {

    public int miceHoleMaxMoves(List<Integer> micePosition, List<Integer> holePosition){
        if(micePosition == null && holePosition == null)
            return 0;
        Collections.sort(micePosition);
        Collections.sort(holePosition);
        
        int n = 0;
        if(micePosition.size() > 0)
            n = micePosition.size();
        
        int maxMoves = 0;
        for(int i=0;i<n;i++){
            maxMoves = Math.max(maxMoves, Math.abs(micePosition.get(i)-holePosition.get(i)));
        }
        return maxMoves;
    }
    
}
