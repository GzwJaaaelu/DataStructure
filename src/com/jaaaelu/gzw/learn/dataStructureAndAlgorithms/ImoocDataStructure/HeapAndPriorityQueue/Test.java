package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.HeapAndPriorityQueue;

import java.util.Arrays;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
//        testMaxHead();
        int[] arr = new int[]{4,1,-1,2,-1,2,3};
        System.out.println(new HighFrequencyElement().topKFrequent(arr, 2));
    }

    private static void testMaxHead() {
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("测试不通过");
            }
        }

        System.out.println("测试完成");

        System.out.println(Arrays.toString(arr));

    }
}
