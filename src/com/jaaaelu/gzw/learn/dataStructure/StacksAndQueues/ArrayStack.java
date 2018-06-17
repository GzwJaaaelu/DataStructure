package com.jaaaelu.gzw.learn.dataStructure.StacksAndQueues;

import com.jaaaelu.gzw.learn.dataStructure.Arrays.DynamicArray;

public class ArrayStack<E> implements Stack<E> {
    private DynamicArray<E> array;

    public ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayStack() {
        array = new DynamicArray<>();
    }

    @Override
    public void push(E element) {
        array.add(0, element);
    }

    @Override
    public E pop() {
        return array.remove(0);
    }

    @Override
    public E peek() {
        return array.get(0);
    }

    @Override
    public int size() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void getCacpcity() {
        array.getCapacity();
    }

    @Override
    public String toString() {
        return getStackStr();
    }

    private String getStackStr() {
        StringBuilder result = new StringBuilder();
        result.append("Stack：");
        result.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if (i == array.getSize() - 1) {
                result.append("]");
            } else {
                result.append(",");
            }
        }
        return result.toString();
    }
}
