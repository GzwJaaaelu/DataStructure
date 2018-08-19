package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.SegmentTree;

/**
 * 以求和为例的线段树
 *
 * @param <E> 范型类型
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = arr[i];
        }
        this.merger = merger;

        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在 treeIndex 的位置创建表示区间 [l, r] 的线段树
     *
     * @param treeIndex 给定位置
     * @param l         左边界
     * @param r         右边界
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            //  此时区间长度为 1，存储元素本身
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        //  严谨版的中值计算
        int mid = l + (r - l) / 2;

        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        //  通过开放的 Merger 接口，进行个性化的线段树处理，比如父节点为两个子节点求和
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 查询某个区间的对应值
     *
     * @param queryL 开始
     * @param queryR 结束
     * @return 区间对应值
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以 treeIndex 的为根的线段树中 [l, r] 的范围内，搜索区间 [queryL, queryR] 的值
     *
     * @param treeIndex 本次的根
     * @param l         本次左边界
     * @param r         本次右边界
     * @param queryL    查询的左边界
     * @param queryR    查询的右边界
     * @return 返回值
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        } else {
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }
    }

    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 在以 treeIndex 为根的线段树中更新 index 的值为 e
     *
     * @param treeIndex 本次的根
     * @param l         本次左边界
     * @param r         本次右边界
     * @param index     本次要更新地方的下标
     * @param e         本次更新值
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        System.out.println("treeIndex -> " + treeIndex);
        System.out.println("l -> " + l);
        System.out.println("r -> " + r);
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        System.out.println("mid -> " + mid);
        int leftTreeIndex = leftChild(treeIndex);
        System.out.println("leftTreeIndex -> " + leftTreeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        System.out.println("rightTreeIndex -> " + rightTreeIndex);
        if (index >= mid + 1) {
            System.out.println("set r");
            set(rightTreeIndex, mid + 1, r, index, e);
        } else {
            System.out.println("set l");
            set(leftTreeIndex, l, mid, index, e);
        }

        //  更新父节点
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }

            if (i != tree.length - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
