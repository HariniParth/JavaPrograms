package com.company;

import java.util.*;

public class Main {

    public String removeDuplicates(String s){

        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        int ip_ind = 1, res_ind = 1;
        while(ip_ind < charArray.length){
            if(charArray[ip_ind] != charArray[ip_ind-1]){
                charArray[res_ind] = charArray[ip_ind];
                res_ind++;
            }
            ip_ind++;
        }

        String str = charArray.toString();

        return str.substring(0, res_ind);
    }
}
