package com.company;

public class Main {

    public void permute(String s, int l, int r){
        if(l == r)
            System.out.println(s);
        else {
            for(int i=l;i<=r;i++){
                s = swap(s, l, i);
                permute(s, l+1, i);
                s = swap(s, l, i);
            }
        }
    }

    public String swap(String s, int i, int j){
        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
