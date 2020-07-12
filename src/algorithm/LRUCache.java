package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: gongran
 * @Date: 2020 2020/7/10 10:47 下午
 */
class LRUCache {
    Map<Integer,Node> map;
    Node head;
    Node tail;
    int capacity = 0;
    private static class Node{
        Node prev = null;
        Node next = null;
        Node(Integer key,Integer value){
            this.key = key;
            this.value = value;
        }
        Integer value;
        Integer key;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap(2*capacity);
        head = new Node(null,null);
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        Node nodeNext = node.next;
        Node nodePrev = node.prev;
        if(node != head.next){
            if(node == tail){
                tail = nodePrev;
                nodePrev.next = null;
            }else{
                nodePrev.next = nodeNext;
                nodeNext.prev = nodePrev;
            }
            addToHead(node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        int size = map.size();
        if(node != null){
            node.value = value;
            if(node == tail){
                tail = node.prev;
                node.prev.next = null;
                addToHead(node);
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
                addToHead(node);
            }
        }else{
            node = new Node(key,value);
            map.put(key,node);
            if(size == capacity){
                map.remove(tail.key);
                if(head.next == tail){
                    head.next = null;
                    tail.prev = null;
                }else {
                    tail = tail.prev;
                    tail.next = null;
                }
            }else if(size < 1){
                head.next = node;
                node.prev = head;
                tail = node;
                return;
            }
            addToHead(node);
        }
    }

    private void addToHead(Node node){
        Node beforeFirst = head.next;
        head.next = node;
        node.prev = head;
        if(beforeFirst == null){
            node.next = null;
            tail = node;
        }else {
            node.next = beforeFirst;
            beforeFirst.prev = node;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        /*cache.put(4,4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));*/
    }
}
