package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.Trie;

import java.util.TreeMap;

/**
 * 添加与搜索单词 - 数据结构设计
 * <p>
 * 题目来自 leetcode
 * https://leetcode-cn.com/problems/map-sum-pairs/description/
 * <p>
 * 用 Trie 来解决这个问题
 */
public class MapSum {
    private Node root;

    private class Node {
        //  当前节点及前面节点是否构成了一个单词
        //  如果 pan 和 panda 都在同一条线上，而 n 和 a 的 isWord 都应该是 true，表明已经构成了一个单词
        int value;
        TreeMap<Character, Node> next;

        Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        Node() {
            this(0);
        }
    }


    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            if (curr.next.get(c) == null) {
                curr.next.put(c, new Node());
            }

            curr = curr.next.get(c);
        }

        curr.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    private int sum(Node node) {
//        //  写不写都行
//        if (node.next.size() == 0) {
//            return node.value;
//        }
        int res = node.value;
        for (char character : node.next.keySet()) {
            res += sum(node.next.get(character));
        }
        return res;
    }
}
