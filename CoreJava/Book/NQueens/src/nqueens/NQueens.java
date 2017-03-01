/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueens;

/**
 *
 * @author harini-geek
 */

public class NQueens {

    class Position{
        int row;
        int col;
        Position(int r, int c){
            row = r;
            col = c;
        }
    }
    
    public Position[] solveNQueens(int n){
        Position[] positions = new Position[n];
        boolean solution = solveNQueens(n, 0, positions);
        if(solution)
            return positions;
        return new Position[0];
    }
    
    public boolean solveNQueens(int n, int row, Position[] position){
        if(n == row)
            return true;
        
        int col;
        for(col=0;col<n;col++){
            boolean foundSafe = true;
            for(int queen = 0;queen<row;queen++){
                if(position[queen].col == col || position[queen].row + position[queen].col == row+col || position[queen].row - position[queen].col == row-col){
                    foundSafe = false;
                    break;
                }                    
            }
            if(foundSafe){
                position[row] = new Position(row, col);
                return true;
            }
        }
        return false;
    }
}
