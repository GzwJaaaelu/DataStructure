package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.HeapAndPriorityQueue;

import com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.Arrays.DynamicArray;

public class MaxHeap<E extends Comparable<E>> {
    private DynamicArray<E> data;

    public MaxHeap(int capacity) {
        data = new DynamicArray<>(capacity);
    }

    public MaxHeap() {
        data = new DynamicArray<>();
    }

    public MaxHeap(E[] arr) {
        data = new DynamicArray<>(arr);
        heapify(arr);
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回该节点的父节点对应的下标
     *
     * @param index 子节点下标
     * @return 父节点下标
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("根节点没有父节点");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回该节点的左节点的对应下标
     *
     * @param index 节点下标
     * @return 该节点下标的左节点对应的下标
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        //  先把元素添加到队尾
        //  为了保证最大堆的性质还要保证新增加的节点值要小于它的父节点，否则就做上浮操作
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮操作
     *
     * @param index 你希望上浮的下标
     */
    private void siftUp(int index) {
        //  下标大于 0
        //  并且 index 节点的父节点的值小于 index 节点的值
        while (index > 0
                && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(parent(index), index);
            //  为下标重新赋值
            index = parent(index);
        }
    }

    public E findMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("当前堆是空的");
        }
        return data.get(0);
    }

    public E extractMax() {
        data.swap(0, size() - 1);
        E e = data.remove(size() - 1);
        siftDown(0);
        return e;
    }

    /**
     * 下沉
     *
     * @param index 想要下沉的元素下标
     */
    private void siftDown(int index) {
//        //  我的逻辑
//        while (index > size() - 1
//                && (data.get(leftChild(index)).compareTo(data.get(index)) > 0
//                || data.get(rightChild(index)).compareTo(data.get(index)) > 0)) {
//            int moveTo = data.get(leftChild(index)).compareTo(data.get(rightChild(index))) > 0
//                    ? leftChild(index) : rightChild(index);
//            data.swap(moveTo, index);
//            //  为下标重新赋值
//            index = moveTo;
//        }

        //  老师的逻辑
        while (leftChild(index) < size()) {
            int j = leftChild(index);
            if (j + 1 < data.getSize()
                    && data.get(j + 1).compareTo(data.get(j)) > 0) {
                //  j 为该节点的左右子节点的最大值的下标
                j = rightChild(index);
            }

            if (data.get(index).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(index, j);
            index = j;
        }
    }

    public E replace(E e) {
        //  先拿到最大值
        E ret = findMax();
        //  值替换
        data.set(0, e);
        //  看是否需要下沉
        siftDown(0);
        return ret;
    }

    /**
     * 将任意数组整理成堆的形状
     * 算法复杂度为 O(n)
     * 如果一个个插入复杂度为 O(nlogn)
     */
    private void heapify(E[] array) {
        for (int i = parent(array.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }
}
