package com.github.zipcodewilmington;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public abstract class DashaMap<K,V> implements HashMapX<K,V>{
    private final Node<K,V>[] list = new Node[26];
    static class Node<K,V>{
        K k;
        V v;
        Node<K,V> next;
        Node(K k, V v){
            this.k = k;
            this.v = v;
            this.next = null;
        }
    }
    public DashaMap(){
        for(char c = 'a'; c <= 'z'; c++){
            list[c-'a'] = new Node(String.valueOf(c),null);
        }
    }

    public Node<K,V>[] getList() {
        return list;
    }

    // Maybe having bitwise shuffling the key when k is not String
    public abstract Integer hashFunction(K input);

    @Override
    public void set(K key, V value) {
        Node<K,V> node = new Node<>(key, value);
        Node cur = list[hashFunction(key)];
        if (cur.next != null) {
            while (cur.next != null) {
                cur = cur.next;
            }
        }
        cur.next = node;
    }

    @Override
    public K delete(K key) {
        Node<K,V> prev = list[hashFunction(key)];
        Node<K,V> cur = prev.next;
        while(cur!=null){
            if(cur.k.equals(key)){
                if(cur.next==null){
                    prev.next = null;
                    return cur.k;
                } else {
                    prev.next = cur.next;
                    cur.next = null;
                    return cur.k;
                }
            }
            prev = prev.next;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public V get(K key) {
        Node<K,V> cur = list[hashFunction(key)];
        while(cur!=null){
            if(cur.k.equals(key)){
                return (V) cur.v;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.size()==0;
    }

    @Override
    public long size() {
        long count = 0;
        for(Node<K,V> node : list){
            count += bucketSize(node.k);
        }
        return count;
    }

    @Override
    public int bucketSize(K key) {
        int count = 0;
        Node<K,V> cur = list[hashFunction(key)];
        while(cur.next!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }

}
