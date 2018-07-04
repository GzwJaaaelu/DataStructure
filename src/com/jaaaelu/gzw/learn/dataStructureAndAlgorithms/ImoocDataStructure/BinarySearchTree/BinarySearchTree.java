package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.BinarySearchTree;

/**
 * 二分搜索树
 *
 * @param <E> 类型 E 具有可比较性
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private Node root;
    private int size;

    /**
     * 二分搜索树的节点类
     */
    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            left = right = null;
        }
    }

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        root = add(root, element);
    }

    private Node add(Node curr, E element) {
        if (curr == null) {
            size++;
            return new Node(element);
        }
        if (element.compareTo(curr.e) > 0) {
            curr.right = add(curr.right, element);
        } else if (element.compareTo(curr.e) < 0) {
            curr.left = add(curr.left, element);
        }

        return curr;
    }

    public boolean contains(E element) {
        return contains(root, element);
    }

    private boolean contains(Node curr, E element) {
        if (curr == null) {
            return false;
        }
        if (element.compareTo(curr.e) == 0) {
            return true;
        } else if (element.compareTo(curr.e) > 0) {
            return contains(curr.right, element);
        } else {
            //  (element.compareTo(curr.e) < 0)
            return contains(curr.left, element);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
