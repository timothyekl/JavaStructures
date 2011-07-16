package com.lithium3141.javastructures.pair;

public class Pair<E> {
    
    private E first;
    private E second;

    public Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return this.first;
    }
    
    public E getSecond() {
        return this.second;
    }

    public void setFirst(E first) {
        this.first = first;
    }
    
    public void setSecond(E second) {
        this.second = second;
    }

}
