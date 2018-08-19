package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.Trie;

public class Test {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("test");
        trie.add("test");
        trie.add("text");
        System.out.println(trie.getSize());

        System.out.println(trie.contains("test"));
        System.out.println(trie.contains("te"));
    }
}
