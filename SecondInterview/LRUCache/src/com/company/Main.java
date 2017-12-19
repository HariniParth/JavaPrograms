package com.company;

import java.util.*;

public class Main{

    private HashMap<Integer, Integer> map = new HashMap<>();
    private ArrayList<Integer> list = new ArrayList<>();
    private int capacity = 0;
    private int count = 0;

    public Main(int c){
        this.capacity = c;
    }

    public int get(int key){
        if(map.containsKey(key)){
            removeNode(key);
            addToFront(key, map.get(key));
            return map.get(key);
        } else
            return -1;
    }

    public int set(int key, int value){
        if(!map.containsKey(key)){
            if(count < capacity){
                addToFront(key, value);
            } else {
                removeLast();
                addToFront(key, value);
            }
        } else {
            removeNode(key);
            addToFront(key, value);
        }
    }

    public void addToFront(int key, int value){
        list.add(0, key);
        map.put(key, value);
        count++;
    }

    public void removeNode(int key){
        int index = list.indexOf(key);
        list.remove(index);
        count--;
    }

    public void removeLast(){
        int key = list.get(list.size()-1);
        list.remove(list.size()-1);
        map.remove(key);
        count--;
    }
}