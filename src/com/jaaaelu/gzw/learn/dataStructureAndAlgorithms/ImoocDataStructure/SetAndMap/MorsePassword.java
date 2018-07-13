package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.SetAndMap;

import java.util.Set;
import java.util.TreeSet;

/**
 * 唯一摩尔斯密码词
 * <p>
 * 题目来自 leetcode
 * https://leetcode-cn.com/problems/unique-morse-code-words/description/
 * <p>
 * 用集合来解决这个问题
 */
public class MorsePassword {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set = new TreeSet<>();

        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                builder.append(codes[word.charAt(i) - 'a']);
            }

            set.add(builder.toString());
        }

        return set.size();
    }
}
