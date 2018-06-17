package com.jaaaelu.gzw.learn.dataStructure.StacksAndQueues;

import com.jaaaelu.gzw.learn.dataStructure.Arrays.DynamicArray;

public class ArrayQueue<E> implements Queue<E> {
    private DynamicArray<E> array;

    public ArrayQueue(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayQueue() {
        array = new DynamicArray<>();
    }


    @Override
    public void enqueue(E element) {
        array.add(array.getSize(), element);
    }

    @Override
    public E dequeue() {
        return array.remove(0);
    }

    @Override
    public E getFront() {
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
        result.append("Queue：");
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
