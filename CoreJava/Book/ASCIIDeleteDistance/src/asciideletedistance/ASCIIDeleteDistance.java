/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asciideletedistance;

/**
 *
 * @author harini-geek
 */
public class ASCIIDeleteDistance {

    public static int deleteDistance(String s1, String s2){
        
        int m = s1.length();
        int n = s2.length();
        
        int[][] distance = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0)
                    distance[i][j] = j;
                if(j==0)
                    distance[i][j] = i;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    distance[i][j] = distance[i-1][j-1];
                else {
                    int min = Math.min(distance[i-1][j-1], distance[i][j-1]);
                    distance[i][j] = 1 + Math.min(min, distance[i-1][j]);
                }
            }
        }
        return distance[m][n];      
    }
    
}
