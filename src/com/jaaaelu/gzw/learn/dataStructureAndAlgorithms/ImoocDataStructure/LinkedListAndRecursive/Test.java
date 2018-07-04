package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.LinkedListAndRecursive;

public class Test {

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        DeleteLinkedListNode.ListNode head = new DeleteLinkedListNode.ListNode(nums);
        System.out.println(head);

        DeleteLinkedListNode.ListNode res = new DeleteLinkedListNode().removeElementsByRecursiveWithTest(head, 6, 0);
        System.out.println(res);
    }
}
