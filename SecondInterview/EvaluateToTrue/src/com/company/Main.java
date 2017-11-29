package com.company;

public class Main {

    int mod = 1003;

    public int solution(String s){

        StringBuilder opnd = new StringBuilder();
        StringBuilder opr = new StringBuilder();

        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'T' || s.charAt(i) == 'F')
                opnd.append(s.charAt(i));
            else
                opr.append(s.charAt(i));
        }

        return evaluate(opnd.toString().toCharArray(), opr.toString().toCharArray());
    }

    public int evaluate(char[] opnd, char[] opr){

        int n = opnd.length;
        int[][] t = new int[n][n];
        int[][] f = new int[n][n];

        for(int i=0;i<n;i++){
            if(opnd[i] == 'T')
                t[i][i] = 1;
            else
                f[i][i] = 1;
        }

        for(int gap=1; gap<n; ++gap){
            for(int i=0, j=gap; j<n; ++i, ++j){
                for(int g=0; g<n; g++){
                    int k = g + i;

                    switch(opr[k]){
                        case '&':
                            t[i][j] = t[i][k] * t[k+1][j];
                            f[i][k] = t[i][k] * f[k+1][j] + f[i][k] * t[k+1][j] + f[i][k] * f[k+1][j];
                            break;
                        case '|':
                            t[i][j] = t[i][k] * t[k+1][j] + t[i][k] * f[k+1][j] + f[i][k] * f[k+1][j];
                            f[i][j] = f[i][k] * f[k+1][j];
                            break;
                        case '^':
                            t[i][j] = t[i][k] * f[k+1][j] + f[i][k] * t[k+1][j];
                            f[i][j] = t[i][k] * t[k+1][j] + f[i][k] * f[k+1][j];
                            break;
                    }

                    t[i][j] %= mod;
                    f[i][j] %= mod;
                }
            }
        }
        return t[0][n-1];
    }
}
