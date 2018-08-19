package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.SegmentTree;

public class Test {

    public static void main(String[] args) {
        Integer[] numnbers = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(numnbers, (a, b) -> a + b);

        System.out.println(segmentTree);

        System.out.println("[0, 2] -> " + segmentTree.query(0, 2));
        System.out.println("[2, 5] -> " + segmentTree.query(2, 5));
        System.out.println("[0, 5] -> " + segmentTree.query(0, 5));

        System.out.println();

        segmentTree.set(3, 5);

        System.out.println(segmentTree);
    }
}
