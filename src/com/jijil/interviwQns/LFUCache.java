package com.jijil.interviwQns;
//Least Frequently Used Cache
// Use LFU when frequent access matters more (e.g., API caching, frequently accessed records).
    /*
    LFU (Least Frequently Used)
    Removes the item with the lowest access count.

    If two items have the same frequency, the older item is evicted (time-based tiebreaker).

    Example:

    Cache capacity: 3

    Operations: put(1), put(2), get(1), put(3), put(4)

    Eviction: Key 2 is evicted (accessed only once, least frequent).*/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Implementation with Priority queue
public class LFUCache {

    private int capacity;
    private Map<Integer,CacheNode> cache;
    private PriorityQueue<CacheNode> minHeap;

    public LFUCache(int capacity) {
        this.capacity =capacity; //capacity of cache ,here 4
        this.cache = new HashMap<>(); // we store cache here
        this.minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.frequency,b.frequency)); //we need sorting by frequency
    }

    private void put(int key, String value) {


        if(cache.containsKey(key)){
            // update value and increment frequency
            CacheNode cacheNode = cache.get(key);
            minHeap.remove(cacheNode);
            cacheNode.setValue(value);
            cacheNode.setFrequency(cacheNode.getFrequency()+1);
            minHeap.offer(cacheNode);
        } else {
            //if new element, if size full remove the lfu element
            if(cache.size() >= capacity) {
                CacheNode evicted = minHeap.poll();
                cache.remove(evicted.key);
            }

            CacheNode newNode = new CacheNode(key ,value);
            cache.put(key,newNode);
            minHeap.offer(newNode);

        }


    }

    private String get(int key) {

        if(!cache.containsKey(key)){
            return "No element";
        }
        // increment frequency in Cache node, and update minheap
        CacheNode cacheNode = cache.get(key);
        minHeap.remove(cacheNode);
        cacheNode.setFrequency(cacheNode.getFrequency() +1 );
        minHeap.offer(cacheNode);
        return  cacheNode.getValue();
    }

    private void display() {
        System.out.println("___________________Printing cache ____________");
        //to print content in cache
        for (CacheNode cNode :minHeap) {
            System.out.println("Key : " + cNode.getKey() + " value : " + cNode.getValue() + " with frequency : " + cNode.getFrequency());
        }

        System.out.println(cache);
    }

    public static void main(String[] args) {

        LFUCache lfuCache = new LFUCache(4);
        lfuCache.put(101, "mohanlal");
        lfuCache.put(201, "mammutty");
        lfuCache.put(301, "fahad");
        lfuCache.put(401, "nivin");

        System.out.println("Get 1: " + lfuCache.get(101));

        lfuCache.put(501,"dulquer");
        lfuCache.put(601,"naslin");

        System.out.println("Get 201: " + lfuCache.get(201));
        System.out.println("Get 301: " + lfuCache.get(301));
        System.out.println("Get 401: " + lfuCache.get(401));
      //  System.out.println("Get 501: " + lfuCache.get(501));

        lfuCache.display();

    }

class CacheNode {

        private  int key;
        private  String value;
        private  int frequency;

        public CacheNode(int key, String value){
            this.key = key;
            this.value =value;
        }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}


}
