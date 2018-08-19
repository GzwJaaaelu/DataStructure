package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.SegmentTree;

import java.util.*;

/**
 * 区域和检索——数组不可修改
 * <p>
 * 题目来自 leetcode
 * https://leetcode-cn.com/problems/range-sum-query-immutable/description/
 * <p>
 * 用线段树来解决这个问题
 */
public class NumArray {
    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < data.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null");
        }
        return segmentTree.query(i, j);
    }
}
