package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.BinarySearchTree;

public class Test {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] numbers = {5, 3, 6, 8, 4, 2};
        for (int number : numbers) {
            bst.add(number);
        }
        //  这棵树应该长这样
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();

        System.out.println();

        bst.preOderNR();

        System.out.println();

        bst.inOrder();

        System.out.println();

        bst.postOrder();

        System.out.println();

        bst.levelOrder();

        System.out.println();

        System.out.println(bst.toString());

        System.out.println();

        bst.removeMinimum();

        bst.inOrder();

        System.out.println();

        bst.removeMax();

        bst.inOrder();

        System.out.println();
    }
}
