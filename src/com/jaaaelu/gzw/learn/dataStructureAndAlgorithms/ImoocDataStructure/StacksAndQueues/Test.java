package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.StacksAndQueues;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
//        testArrayStack();
//        testArrayQueue();
//        testLoopQueue();
//        testLoopQueueByTeacher();

        System.out.println("ArrayQueue, time: " +  testQueue(new ArrayQueue<>(), 100000) + " s");
        System.out.println("LoopQueue, time: " +  testQueue(new LoopQueue<>(), 100000) + " s");
    }


    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


    private static void testLoopQueueByTeacher() {
        LoopQueueByTeacher<Integer> queue = new LoopQueueByTeacher<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    private static void testArrayStack() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println(arrayStack);

        System.out.println("arrayStack.pop() -> " + arrayStack.pop());
        System.out.println(arrayStack);

        System.out.println("arrayStack.peek() -> " + arrayStack.peek());
        System.out.println(arrayStack);
    }

    private static void testArrayQueue() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue);

        System.out.println("arrayQueue.dequeue() -> " + arrayQueue.dequeue());
        System.out.println(arrayQueue);

        System.out.println("arrayQueue.getFront() -> " + arrayQueue.getFront());
        System.out.println(arrayQueue);
    }

    private static void testLoopQueue() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
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
