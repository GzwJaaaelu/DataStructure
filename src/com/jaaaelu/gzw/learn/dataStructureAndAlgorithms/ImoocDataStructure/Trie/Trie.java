package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.Trie;

import java.util.TreeMap;

public class Trie {
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

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向 Trie 中添加一个新的单词
     *
     * @param word 单词
     */
    public void add(String word) {
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

    public boolean contains(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (curr.next.get(c) == null) {
                return false;
            }

            curr = curr.next.get(c);
        }

        return curr.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (curr.next.get(c) == null) {
                return false;
            }

            curr = curr.next.get(c);
        }

        return true;
    }
}
