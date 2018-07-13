package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.SetAndMap;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node curr, K key, V value) {
        if (curr == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(curr.key) > 0) {
            curr.right = add(curr.right, key, value);
        } else if (key.compareTo(curr.key) < 0) {
            curr.left = add(curr.left, key, value);
        } else {
            //  key.compareTo(curr.key) == 0
            curr.value = value;
        }

        return curr;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    /**
     * 删除以 Node 为根的二分搜索树中值为 key 的节点，递归
     *
     * @param node 根
     * @param key    值
     * @return 删除后的根
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            //  比当前 node 值要小去看左子树
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            //  比当前 node 值要大去看右子树
            node.right = remove(node.right, key);
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

    private Node findMinimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return findMinimum(node.left);
    }

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

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node != null) {
            node.value = value;
        } else {
            throw new IllegalArgumentException(key + " 不存在。");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return node;
        }
    }

    class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
