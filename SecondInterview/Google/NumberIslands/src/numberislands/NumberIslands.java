/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberislands;

/**
 *
 * @author harini-geek
 * https://www.geeksforgeeks.org/find-number-of-islands/
 */

public class NumberIslands {

    private final int ROW = 4, COL = 4;
    
    boolean isSafe(int[][] matrix, int row, int col, boolean[][] visited){
        return ((row >= 0 && row < ROW) && 
                (col >= 0 && col < COL) && 
                matrix[row][col] == 1 && 
                !visited[row][col]);
    }
    
    void DFS(int[][] matrix, int row, int col, boolean[][] visited){
        int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        visited[row][col] = true;
        
        for(int i=0;i<8;i++){
            if(isSafe(matrix, row+rowNbr[i], col+colNbr[i], visited))
                DFS(matrix, row+rowNbr[i], col+colNbr[i], visited);
        }
    }
    
    int islands(int[][] matrix){
        boolean[][] visited = new boolean[ROW][COL];
        for(int i=0;i<ROW;i++)
            for(int j=0;j<COL;j++)
                visited[i][j] = false;
        
        int count = 0;
        for(int i=0;i<ROW;i++)
            for(int j=0;j<COL;j++)
                if(matrix[i][j] == 1 && !visited[i][j]){
                    count++;
                    DFS(matrix, i, j, visited);
                }
        
        return count;
    }
    
}
