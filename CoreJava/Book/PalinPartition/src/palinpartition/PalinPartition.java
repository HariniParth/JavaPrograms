/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palinpartition;

import java.util.*;

/**
 *
 * @author harini-geek
 */
public class PalinPartition{
    
    private ArrayList<ArrayList<String>> result;
    private int[][] isPalin;
    private String string;
    private int N;
    
    public ArrayList<ArrayList<String>> solution(String S){
        result = new ArrayList<>();
        string = S;
        N = S.length();
        
        if(N==0)
            return null;
        isPalin = new int[N][N];
        
        for(int i=0;i<N;i++)
            Arrays.fill(isPalin[i], -1);
        
        ArrayList<String> str = new ArrayList<>();
        rec(str, 0);
        return result;
    }
    
    public void rec(ArrayList<String> str, int index){
        if(index == N)
            result.add(new ArrayList<>(str));
        
        for(int i=index;i<N;i++){
            if(isPalindrome(index, i)){
                str.add(string.substring(index, i+1));
                rec(str, i+1);
                str.remove(str.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(int start, int end){
        if(start < 0 || start >= N || end < 0 || end >= N)
            return false;
        
        if(isPalin[start][end] != -1)
            isPalin[start][end] = 1;
        
        int i, j;
        for(i=start,j=end;i<j;i++,j--){
            if(string.charAt(i) != string.charAt(j)){
                isPalin[start][end] = 0;
                return false;
            }
        }
        return true;
    }
}