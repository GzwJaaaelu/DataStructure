package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.LinkedList;

public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0, 1);
        linkedList.add(1, 2);
        linkedList.add(2, 3);
        linkedList.addFirst(0);
        System.out.println(linkedList);
        linkedList.add(1, 666);
        System.out.println(linkedList);
        linkedList.delete(1);
        System.out.println(linkedList);

        System.out.println("-----------------------------");

        testLinkedStack();

        System.out.println("-----------------------------");

        testLinkedQueue();
    }


    private static void testLinkedStack() {
        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        System.out.println(listStack);

        System.out.println("listStack.pop() -> " + listStack.pop());
        System.out.println(listStack);

        System.out.println("listStack.peek() -> " + listStack.peek());
        System.out.println(listStack);

        System.out.println("listStack.peek() -> " + listStack.peek());
        System.out.println("listStack.peek() -> " + listStack.peek());
        System.out.println("listStack.isEmpty() -> " + listStack.isEmpty());
        System.out.println(listStack);

        for (int i = 0; i < 10; i++) {
            listStack.push(i);
        }
        System.out.println(listStack);
        for (int i = 0; i < 10; i++) {
            System.out.println("listStack.peek() -> " + listStack.pop());
            System.out.println(listStack);
        }
    }


    private static void testLinkedQueue() {
        LinkedListQueue<Integer> loopQueue = new LinkedListQueue<>();
        loopQueue.enqueue(1);
        loopQueue.enqueue(2);
        loopQueue.enqueue(3);
        System.out.println(loopQueue);

        System.out.println("arrayQueue.dequeue() -> " + loopQueue.dequeue());
        System.out.println(loopQueue);

        System.out.println("arrayQueue.getFront() -> " + loopQueue.getFront());
        System.out.println(loopQueue);

        System.out.println("arrayQueue.dequeue() -> " + loopQueue.dequeue());
        System.out.println("arrayQueue.dequeue() -> " + loopQueue.dequeue());
        System.out.println("arrayQueue.isEmpty() -> " + loopQueue.isEmpty());
        System.out.println(loopQueue);

        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        for (int i = 0; i < 10; i++) {
            System.out.println("arrayQueue.dequeue() -> " + loopQueue.dequeue());
            System.out.println(loopQueue);
        }
    }
}
