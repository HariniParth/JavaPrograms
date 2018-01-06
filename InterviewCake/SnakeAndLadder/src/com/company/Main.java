package com.company;

import java.util.*;

// https://www.geeksforgeeks.org/snake-ladder-problem-2/

// Time Complexity: O(n)

public class Main {

    class Cell{
        int cell;
        int distance;
    }

    public int snakeAndLadder(int[] moves, int N){

        Queue<Cell> queue = new LinkedList<>();
        Cell cell = new Cell();
        cell.cell = 0;
        cell.distance = 0;
        queue.add(cell);

        boolean[] visited = new boolean[N];
        visited[0] = true;

        while(!queue.isEmpty()){
            cell = queue.remove();
            int v = cell.cell;
            if(v == N-1)
                break;

            for(int i=v+1;i<=v+6 && i<N;i++){
                if(!visited[i]){
                    Cell nextCell = new Cell();
                    nextCell.distance = cell.distance + 1;
                    visited[i] = true;

                    if(moves[i] != -1)
                        nextCell.cell = moves[i];
                    else
                        nextCell.cell = i;

                    queue.add(nextCell);
                }
            }
        }
        return cell.distance;
    }
}
