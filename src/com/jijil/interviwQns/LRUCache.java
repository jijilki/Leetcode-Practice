package com.jijil.interviwQns;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
LRU Cache using LinkedHashSet to preserve the order
 Least recently used cache
 Use LRU when recent access is more relevant (e.g., session management, browser cache).
**/
public class LRUCache {


    Integer cacheSize;

    Set<Integer> cache;

    LRUCache(Integer cacheSize){

        this.cacheSize = cacheSize;
        cache = new LinkedHashSet<>();
    }


    private void refer(Integer x) {

        if(!cache.contains(x)){
            put(x);
        }else{
            cache.remove(x);
            cache.add(x);
        }


    }

    private void put(Integer x) {

        if(cache.size() < cacheSize){
            cache.add(x);
        }else {
            Integer firstElement = cache.iterator().next();
            cache.remove(firstElement);
            cache.add(x);
        }

    }


    private void print() {

        LinkedList<Integer> linkedList = new LinkedList<>(cache);
        Iterator<Integer> itr = linkedList.descendingIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }

    //Driver Method

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(4);
        lruCache.refer(1);
        lruCache.refer(2);
        lruCache.refer(3);
        lruCache.refer(4);
        lruCache.refer(5);
        lruCache.refer(6);
        lruCache.refer(2);
        lruCache.refer(2);
        lruCache.print();



    }




}
