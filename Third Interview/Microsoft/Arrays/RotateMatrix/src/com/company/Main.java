package com.company;

public class Main {

    private void rotateMatrix(int[][] matrix){

        int n = matrix.length;

        for(int i=0;i<n/2;i++){
            for(int j=0;j<n-1-i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = temp;
            }
        }
    }
}
