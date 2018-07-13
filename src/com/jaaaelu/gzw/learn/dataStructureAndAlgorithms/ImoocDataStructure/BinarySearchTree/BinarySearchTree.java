package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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
            //  (element.compareTo(curr.key) < 0)
            return contains(curr.left, element);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.print("前序遍历结果：");
        preOrder(root);
    }

    /**
     * 递归的前序遍历方法
     *
     * @param node 节点
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        //  这里遍历的操作就是打印元素值
        System.out.print(node.e + " ");
        //  然后继续看左右节点
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 使用递归进行前序排列
     */
    public void preOderNR() {
        System.out.print("非递归的前序遍历结果：");
        //  思路是利用栈，先进后出
        //  先访问当前元素，然后对当前元素进行操作，然后将当前元素的右子树先加入栈，再将当前元素左子树加入栈，进行循环
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.e + " ");
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        System.out.print("中序遍历结果：");
        inOrder(root);
    }

    /**
     * 递归的中序遍历方法
     *
     * @param node 节点
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        //  这里遍历的操作就是打印元素值
        System.out.print(node.e + " ");
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        System.out.print("后序遍历结果：");
        postOrder(root);
    }

    /**
     * 递归的后序遍历方法
     *
     * @param node 节点
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        //  这里遍历的操作就是打印元素值
        System.out.print(node.e + " ");
    }

    /**
     * 广度优先遍历
     * 层序遍历
     * <p>
     * 优点在于可以更快的进行查询，它是一层一层看的
     */
    public void levelOrder() {
        System.out.println("层序遍历结果：");
        //  这次借助的是队列
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.e + " ");
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
    }

    /**
     * 找到最小值
     *
     * @return 最小值
     */
    public E findMinimum() {
        if (size == 0) {
            throw new UnsupportedOperationException("二分搜索树为空不支持搜索最小值操作");
        }
        return findMinimum(root).e;
    }

    private Node findMinimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return findMinimum(node.left);
    }

    /**
     * 找到最小值
     *
     * @return 最小值
     */
    public E findMax() {
        if (size == 0) {
            throw new UnsupportedOperationException("二分搜索树为空不支持搜索最小值操作");
        }
        return findMax(root).e;
    }

    private Node findMax(Node node) {
        if (node.right == null) {
            return node;
        }

        return findMinimum(node.right);
    }

    public E removeMinimum() {
        E ret = findMinimum();

        //  删除后的新的 root 需要重新赋值
        root = removeMinimum(root);

        return ret;
    }

    /**
     * 删掉最小值所在的节点
     *
     * @param node 每次都是一个根节点
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node removeMinimum(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMinimum(node.left);
        return node;
    }

    public E removeMax() {
        E ret = findMax();

        //  删除后的新的 root 需要重新赋值
        root = removeMax(root);

        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以 Node 为根的二分搜索树中值为 key 的节点，递归
     *
     * @param node 根
     * @param e    值
     * @return 删除后的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            //  比当前 node 值要小去看左子树
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            //  比当前 node 值要大去看右子树
            node.right = remove(node.right, e);
            return node;
        } else {
            //  key.compareTo(node.key) == 0

            //  左子树为空
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }

            //  右子树为空
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }

            //  两个子节点都不为空
            //  找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //  用这个节点顶替掉待删除节点的位置
            Node successor = findMinimum(node.right);
            successor.right = removeMinimum(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }
        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
