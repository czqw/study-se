package com.czq.collection.MapImpl;

import java.util.*;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/20
 */
public class CzqMap<K,V> extends AbstractMap<K,V> implements Map<K,V> {

    private int size;
    private static int capacity = 10;
    private LinkedList[] arr;
    public List<Long> repeatList = new ArrayList();
    public float loadFector = 0.75F;


    public CzqMap(){
       arr = new LinkedList[capacity];
    }

    public CzqMap(int capacity){
        arr = new LinkedList[capacity];
    }

    final int capacity(){
        return arr.length;
    }

    @Override
    public boolean containsKey(Object key){
        return getEntry(key) != null;
    }

    private Object getEntry(Object key) {
        int hash = key.hashCode() < 0 ? -key.hashCode() : key.hashCode();
        int index = hash % arr.length;

        LinkedList list = arr[index];
        for (int i = 0; i < list.size(); i++) {
            com.czq.collection.MapImpl.Entry e = (com.czq.collection.MapImpl.Entry) list.get(i);
            if (e.getKey().equals(key)){
                return e.getValue();
            }
        }
        return null;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V put(K key,V value){
        com.czq.collection.MapImpl.Entry  entry = new com.czq.collection.MapImpl.Entry(key,value);

        int hash = key.hashCode();
        hash = hash<0? -hash: hash;

        int index = hash % arr.length;

        if (arr[index] == null){
            LinkedList list = new LinkedList();
            arr[index] = list;
            list.add(entry);
            size++;
            return (V) entry.getValue();
        }
        LinkedList list = arr[index];
        for (int i = 0; i < list.size(); i++) {
            com.czq.collection.MapImpl.Entry e = (com.czq.collection.MapImpl.Entry) list.get(i);
            if (e.getKey().equals(key)){
                repeatList.add((Long) e.getValue());
                e.setValue(value);
                return value;
            }
        }
        list.add(entry);
        size++;
        rehash();
        return null;
    }

    private void rehash() {
        if (size > capacity() * loadFector){
            LinkedList[] l = new LinkedList[arr.length] ;
            for(int k=0;k<arr.length;k++){
                l[k]=new LinkedList();
                LinkedList tem = null;
                if ((tem = arr[k]) != null){
                    for(int y=0;y<tem.size();y++){
                        l[k].add(tem.get(y));
                    }
                }

            }

            arr = new LinkedList[2*capacity()];
            for(int i = 0; i<l.length ; i++){
                LinkedList ll =l[i];
                for (int j=0;j<ll.size();j++){
                    com.czq.collection.MapImpl.Entry e = (com.czq.collection.MapImpl.Entry) ll.get(j);
                    put((K) e.getKey(),(V) e.getValue());
                }
            }
        }
    }

    @Override
    public V get(Object key){

        int hash = key.hashCode() < 0 ? -key.hashCode() : key.hashCode();
        int index = hash % arr.length;

        LinkedList list = null;
        if ((list = arr[index])!= null){
            for (int i = 0; i < list.size(); i++) {
                com.czq.collection.MapImpl.Entry e = (com.czq.collection.MapImpl.Entry) list.get(i);
                if (e.getKey().equals(key)){
                    return (V) e.getValue();
                }
            }
        }
        return null;
    }
}


class Entry{


    private Object key;
    private Object value;


    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}