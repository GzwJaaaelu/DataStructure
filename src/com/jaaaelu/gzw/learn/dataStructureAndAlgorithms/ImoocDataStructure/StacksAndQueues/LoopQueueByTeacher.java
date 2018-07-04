package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.StacksAndQueues;

public class LoopQueueByTeacher<E> implements Queue<E> {
    private static final int DEFAULT_ARRAY_CAPACITY = 10;
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueueByTeacher(int capacity) {
        //  由于需要有意识的浪费一个数组空间
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueByTeacher() {
        this(DEFAULT_ARRAY_CAPACITY);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isQueueFull() {
        return (tail + 1) % data.length == front;
    }

    @Override
    public void enqueue(E element) {
        if (isQueueFull()) {
            resize(getCapacity() * 2);
        }
        data[tail] = element;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("队列已经为空，无法继续出队");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }


    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        return getArrayStr();
    }

    /**
     * 获取有些的打印内容
     *
     * @return 有效的数组内容打印
     */
    private String getArrayStr() {
        StringBuilder arrStr = new StringBuilder();
        arrStr.append(String.format("LoopQueue：size = %d，capacity = %d", size, getCapacity()));
        arrStr.append("\n");
        arrStr.append("[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            arrStr.append(data[i]);
            if ((i + 1) % data.length != tail) {
                arrStr.append(",");
            }
        }
        arrStr.append("]");
        return arrStr.toString();
    }
}
