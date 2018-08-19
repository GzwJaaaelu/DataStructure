package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.SegmentTree;

/**
 * 区域和检索——数组不可修改
 * <p>
 * 题目来自 leetcode
 * https://leetcode-cn.com/problems/range-sum-query-immutable/description/
 * <p>
 * 用简单方法来解决这个问题
 */
public class NumArrayByOtherWay {
    //  sum[i] 存储的其实是前 i 个元素的和，sum[0] = 0
    //  sum[i] 存储 num[0 ... i-1] 的和
    private int[] sum;

    public NumArrayByOtherWay(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        //  sum[j + 1] -> [0...j]
        //  sum[i] -> [0...i-1]
        return sum[j + 1] - sum[i];
    }
}
