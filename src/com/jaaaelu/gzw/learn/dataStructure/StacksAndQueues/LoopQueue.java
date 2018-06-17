package com.jaaaelu.gzw.learn.dataStructure.StacksAndQueues;

import java.util.Arrays;

public class LoopQueue<E> implements Queue<E> {
    private static final int DEFAULT_ARRAY_CAPACITY = 10;
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        //  由于需要有意识的浪费一个数组空间
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(DEFAULT_ARRAY_CAPACITY);
    }

    @Override
    public void enqueue(E element) {
        add(element);
    }

    /**
     * 向数组某个位置插入值，本来这个地方以及后面的值向后移动一位
     *
     * @param element 对应值
     */
    public void add(E element) {
        if (isQueueFull()) {
            //  如果满了就扩容，大小为当前容量 * 2
            resize(2 * getCapacity());
        }
        data[size] = element;
        size++;
        tail++;
    }

    /**
     * 数组扩容
     * @param newCapacity 扩容后长度
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        //  这里是关键
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        return remove();
    }


    /**
     * 移除对应下标的元素值
     */
    public E remove() {
        E ret = data[front];
        size--;
        //  队首的元素就没有
        data[front] = null;

        front++;
        //  防止复杂度震荡，这里我们修改为当有效长度为容量四分之一时，才将容量减半
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        if (isEmpty()) {
            front = tail = 0;
        }

        return ret;
    }


    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public boolean isQueueFull() {
        return (tail + 1) % data.length == front;
    }

    /**
     * 返回数组类的容量
     *
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        return getStackStr();
    }

    private String getStackStr() {
        StringBuilder result = new StringBuilder();
        result.append("Queue：");
        result.append("[");
        for (int i = front; i < tail; i++) {
            result.append(data[i]);
            if (i == tail - 1) {
                result.append("]    ");
            } else {
                result.append("，");
            }
        }
        result.append("front：").append(front);
        result.append("，");
        result.append("tail：").append(tail);
        result.append("，");
        result.append("size：").append(size);
        result.append("，");
        result.append(Arrays.toString(data));
        return result.toString();
    }
}
