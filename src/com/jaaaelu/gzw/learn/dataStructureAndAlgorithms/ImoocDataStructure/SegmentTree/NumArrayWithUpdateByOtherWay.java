package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.SegmentTree;

/**
 * 区域和检索——数组可修改
 * <p>
 * 题目来自 leetcode
 * https://leetcode-cn.com/problems/range-sum-query-mutable/description/
 * <p>
 * 用线段树来解决这个问题
 */
public class NumArrayWithUpdateByOtherWay {
    //  sum[i] 存储的其实是前 i 个元素的和，sum[0] = 0
    //  sum[i] 存储 num[0 ... i-1] 的和
    private int[] sum;

    private int[] data;

    public NumArrayWithUpdateByOtherWay(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = nums[i];
        }

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int i, int val) {
        data[i] = val;
        for (int j = i + 1; j < sum.length; j++) {
            sum[j] = sum[j - 1] + data[j - 1];
        }
    }

    public int sumRange(int i, int j) {
        //  sum[j + 1] -> [0...j]
        //  sum[i] -> [0...i-1]
        return sum[j + 1] - sum[i];
    }
}
