package com.zhou.springboot.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LRUCache {

    class Node {
        //        Node prev;
//        Node next;
        String key;
        Object value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
    //用于hash寻址，主要是满足时间复杂度为O(1)(理想情况下)
    protected Map<String, Node> map = new HashMap<>();
    protected Queue<Node> queue = new ConcurrentLinkedQueue<>();
    private final int capcaity;

    LRUCache(int capcaity) {
        if (capcaity <= 0) {
        }
        this.capcaity = capcaity;
    }

    public Object get(String key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        queue.remove(node);
        queue.offer(node);
        return node.getValue();
    }

    public void put(String key, Object value) {
        //evict expired
        if (queue.size() >= capcaity) {
            Node old = queue.poll();
            map.remove(old.key);
        }
        if (!map.containsKey(key)) {
            Node n = new Node(key, value);
            queue.offer(n);
            map.put(key, n);
        } else {
            Node node = map.get(key);
            queue.remove(node);
            Node n = new Node(key, value);
            queue.offer(n);
            map.put(key, n);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put("1", 1);
        cache.put("2", 2);
        System.out.println(cache.get("1"));       // 返回  1
        cache.put("3", 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get("2"));       // 返回 -1 (未找到)
        cache.put("4", 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get("1"));       // 返回 -1 (未找到)
        System.out.println(cache.get("3"));       // 返回  3
        System.out.println(cache.get("4"));       // 返回  4
    }


   static  class CQueue {

        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if(stack2.isEmpty()){
                if(stack1.isEmpty()){
                    return -1;
                }
                Integer size = stack1.size();
                for (int i = 0; i < size; i++) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public static void main(String[] args) {
            CQueue q = new CQueue();
            q.appendTail(5);
            q.appendTail(2);
            System.out.println(q.deleteHead());
            System.out.println(q.deleteHead());
            System.out.println();
        }

    }



}
