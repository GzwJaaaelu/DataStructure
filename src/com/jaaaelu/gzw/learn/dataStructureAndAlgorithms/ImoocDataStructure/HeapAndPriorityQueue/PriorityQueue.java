package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.HeapAndPriorityQueue;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;

    @Override
    public void enqueue(E element) {
        maxHeap.add(element);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
