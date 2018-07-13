package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.SetAndMap;

public class Test {

    public static void main(String[] args) {

        testLinkedListMap();
    }

    private static void testLinkedListMap() {
        LinkedListMap<String, Integer> map = new LinkedListMap<>();
        map.add("a", 1);
        map.add("b", 2);
        map.add("a", 1);

        System.out.println(map.size());
    }
}
