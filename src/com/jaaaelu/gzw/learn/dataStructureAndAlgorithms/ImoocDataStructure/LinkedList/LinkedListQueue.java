package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.LinkedList;

import com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.StacksAndQueues.Queue;

public class LinkedListQueue<E> implements Queue<E> {
    //  指向链表头
    private Node head;
    //  指向链表尾
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E element) {
        if (tail == null) {
            tail = new Node(element);
            head = tail;
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return head.e;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node node = head;
        while (node != null) {
            builder.append(node.e).append(" -> ");
            node = node.next;
        }
        builder.append("NULL");
        return builder.toString();
    }

    //  用户无需知道内部实习细节
    class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
