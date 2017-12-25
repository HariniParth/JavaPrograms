package com.company;

// https://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/

public class Main {

    public void floodFill(char[][] arr){

        int m = arr.length;
        int n = arr[0].length;

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(arr[i][j] == 'O')
                    arr[i][j] = '-';

        for(int i=0;i<m;i++)
            if(arr[i][0] == '-')
                floodFillUtil(arr, i, 0, '-', 'O');

        for(int i=0;i<m;i++)
            if(arr[i][n-1] == '-')
                floodFillUtil(arr, i, n-1, '-', 'O');

        for(int j=0;j<n;j++)
            if(arr[0][j] == '-')
                floodFillUtil(arr, 0, j, '-', 'O');

        for(int j=0;j<n;j++)
            if(arr[m-1][j] == '-')
                floodFillUtil(arr, m-1, j, '-', 'O');

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(arr[i][j] == '-')
                    arr[i][j] = 'X';

    }

    public void floodFillUtil(char[][] arr, int x, int y, char prev, char next){

        int m = arr.length;
        int n = arr[0].length;

        if(x < m || x >= m || y < 0 || y >= n)
            return;
        if(arr[x][y] != prev)
            return;

        arr[x][y] = next;
        floodFillUtil(arr, x+1, y, prev, next);
        floodFillUtil(arr, x-1, y, prev, next);
        floodFillUtil(arr, x, y+1, prev, next);
        floodFillUtil(arr, x, y-1, prev, next);
    }
}
