package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.HeapAndPriorityQueue;

import java.util.*;
import java.util.PriorityQueue;

/**
 * 前K个高频元素
 * <p>
 * 题目来自 leetcode
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 * <p>
 * 用堆来解决这个问题
 */
public class HighFrequencyElement {

    public List<Integer> topKFrequent(int[] nums, int k) {
        //  先遍历统计频次
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //  利用优先队列来计算前 k 个频次高的
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.poll();
                pq.offer(key);
            }
        }

        List<Integer> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}
