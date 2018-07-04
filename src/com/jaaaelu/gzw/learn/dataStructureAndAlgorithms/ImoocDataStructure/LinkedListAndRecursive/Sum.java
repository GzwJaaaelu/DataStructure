package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.LinkedListAndRecursive;

public class Sum {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 1; i <= 100; i++) {
            arr[i-1] = i;
        }

        System.out.println("arr sum -> " + sum(arr));
    }

    private static int sum(int[] arr) {
        return sum(arr, 0);
    }

    //  计算 arr[l ... n) 这个区间内所有数字的和
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            //  求解最基本的问题
            return 0;
        } else {
            //  把原问题转化成更小的问题
            return arr[l] + sum(arr, l + 1);
        }
    }
}
