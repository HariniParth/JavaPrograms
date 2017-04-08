/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagrams;
import java.util.*;

/**
 *
 * @author harini-geek
 */
public class Anagrams {

   public ArrayList<ArrayList<Integer>> anaGrams(List<String> strings){
       
       ArrayList<ArrayList<Integer>> result = new ArrayList<>();
       HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
       int i = 0;
       
       for(String str : strings){
           
           char[] charArray = str.toCharArray();
           Arrays.sort(charArray);
           String string = new String(charArray);
           
           if(hashMap.containsKey(string)){
               ArrayList<Integer> list = hashMap.get(string);
               list.add(i);
           } else {
               ArrayList<Integer> list = new ArrayList<>();
               list.add(i);
               hashMap.put(string, list);
           }
           i++;
       }
       
       for(Map.Entry<String, ArrayList<Integer>> entrySet : hashMap.entrySet()){
           result.add(entrySet.getValue());
       }
       
       return result;
   }
    
}
