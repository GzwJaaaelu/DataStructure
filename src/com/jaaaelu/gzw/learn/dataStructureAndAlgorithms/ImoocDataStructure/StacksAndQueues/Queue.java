package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.StacksAndQueues;

/**
 * 栈的一些基本操作：
 * - 加入队列 void enqueue(E)
 * - 从队列中取出 E dequeue()
 * - 从队列中取出但不移除 E getFront()
 * - 栈大小 int size()
 * - 是否为空 boolean isEmpty()
 */
public interface Queue<E> {

    void enqueue(E element);

    E dequeue();

    E getFront();

    int size();

    boolean isEmpty();
}
