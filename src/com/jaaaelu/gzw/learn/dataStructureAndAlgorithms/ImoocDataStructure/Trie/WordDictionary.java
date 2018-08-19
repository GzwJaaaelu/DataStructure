package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.Trie;

import java.util.TreeMap;

/**
 * 添加与搜索单词 - 数据结构设计
 * <p>
 * 题目来自 leetcode
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/description/
 * <p>
 * 用 Trie 来解决这个问题
 */
public class WordDictionary {
    private Node root;
    private int size;

    private class Node {
        //  当前节点及前面节点是否构成了一个单词
        //  如果 pan 和 panda 都在同一条线上，而 n 和 a 的 isWord 都应该是 true，表明已经构成了一个单词
        boolean isWord;
        TreeMap<Character, Node> next;

        Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        Node() {
            this(false);
        }
    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
        size = 0;
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (curr.next.get(c) == null) {
                curr.next.put(c, new Node());
            }

            curr = curr.next.get(c);
        }

        //  判断是否是一个新的单词，而不是已经存在，已经存在 size 无需改变
        if (!curr.isWord) {
            curr.isWord = true;
            size++;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     * <p>
     * addWord("bad")
     * addWord("dad")
     * addWord("mad")
     * search("pad") -> false
     * search("bad") -> true
     * search(".ad") -> true
     * search("b..") -> true
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            for (char nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
