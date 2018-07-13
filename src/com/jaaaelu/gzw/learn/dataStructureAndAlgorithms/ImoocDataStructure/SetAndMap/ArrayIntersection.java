package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.SetAndMap;

import java.util.*;
import java.util.Map;
import java.util.Set;

/**
 * 两个数组的交集 I
 * 两个数组的交集 II
 * <p>
 * 题目来自 leetcode
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 * <p>
 * I    用集合来解决这个问题
 * II   用映射来解决这个问题
 */
public class ArrayIntersection {

    public int[] intersectionI(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        List<Integer> list = new ArrayList<>();

        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersectionII(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
