package com.company;

// https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/

import java.util.*;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    public void setData(T data){
        this.data = data;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public T getData(){
        return data;
    }

    public Node<T> getNext(){
        return next;
    }
}

class List<T> implements Iterable<T> {

    Node<T> head, tail;

    public void add(T data){
        Node<T> node = new Node(data, null);
        if(head == null)
            tail = head = node;
        else {
            tail.setNext(node);
            tail = node;
        }
    }

    public Node<T> getHead(){
        return head;
    }

    public Node<T> getTail(){
        return tail;
    }

    public ListIterator<T> iterator(){
        return new ListIterator<T>(this);
    }
}

class ListIterator<T> implements Iterator<T> {

    Node<T> current;

    public ListIterator(List<T> list){
        current = list.getHead();
    }

    public boolean hasNext(){
        return current != null;
    }

    public T next(){
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    public void remove(){
        Node<T> rm = current;
        current = current.getNext();
        rm = null;
    }
}