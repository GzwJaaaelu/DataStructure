package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.SetAndMap;

import com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.BinarySearchTree.BinarySearchTree;

/**
 * 基于二分搜索树的集合
 *
 * @param <E>
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> bst;

    public BSTSet() {
        bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E element) {
        bst.add(element);
    }

    @Override
    public void remove(E element) {
        bst.remove(element);
    }

    @Override
    public boolean contains(E element) {
        return contains(element);
    }

    @Override
    public int size() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
