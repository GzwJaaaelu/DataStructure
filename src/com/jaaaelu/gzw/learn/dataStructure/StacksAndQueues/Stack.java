package com.jaaaelu.gzw.learn.dataStructure.StacksAndQueues;

/**
 * 栈的一些基本操作：
 * - 入栈 void push(E)
 * - 出栈 E pop()
 * - 查看顶部但不出栈 E peek()
 * - 栈大小 int size()
 * - 是否为空 boolean isEmpty()
 */
public interface Stack<E> {

    void push(E element);

    E pop();

    E peek();

    int size();

    boolean isEmpty();
}
