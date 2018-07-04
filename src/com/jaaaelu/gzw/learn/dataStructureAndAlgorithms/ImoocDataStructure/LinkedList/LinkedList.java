package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.LinkedList;

public class LinkedList<E> {
    //    //  指向链表头
//    private Node head;
    //  虚拟头节点
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //  引入虚拟头这个方法需要修改
//    public void addFirst(E element) {
////        Node node = new Node(element, head);
////        node.next = head;
////        head = node;
//        //  和上面三行效果一样
//        head = new Node(element, head);
//        size++;
//    }

    public void add(int index, E element) {
        //  关键就是找到要添加节点的前一个节点
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("大哥这个参数真的真的不合法：" + index);
        }
        //  引入虚拟头节点之后无需做特殊处理
//        if (index == 0) {
//            addFirst(element);
//        } else {
//            Node prevNode = head;
//            for (int i = 0; i < index - 1; i++) {
//                prevNode = prevNode.next;
//            }
////            Node node = new Node(element, prevNode.next);
////            prevNode.next = node;
//            //  简化
//            prevNode.next = new Node(element, prevNode.next);
//            size++;
//        }

        Node prevNode = dummyHead;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }
        prevNode.next = new Node(element, prevNode.next);
        size++;
    }

    public void addFirst(E element) {
        add(0, element);
    }

    public void addLast(E element) {
        add(size, element);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("大哥这个参数真的真的不合法：" + index);
        }

        Node currNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLase() {
        return get(size - 1);
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("大哥这个参数真的真的不合法：" + index);
        }

        Node currNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        currNode.e = element;
    }

    public void setFist(E element) {
        set(0, element);
    }

    public boolean contains(E element) {
        Node node = dummyHead.next;
        while (node != null) {
            if (element.equals(node.e)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public E delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("大哥这个参数真的真的不合法：" + index);
        }

        Node prevNode = dummyHead;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }
        Node deleteNode = prevNode.next;
        prevNode.next = deleteNode.next;
        deleteNode.next = null;
        E ret = deleteNode.e;
        deleteNode.e = null;
        size--;
        return ret;
    }

    public E deleteFirst() {
        return delete(0);
    }

    public E deleteLast() {
        return delete(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node node = dummyHead.next;
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
