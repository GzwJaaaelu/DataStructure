package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.StacksAndQueues;

import java.util.Stack;

/**
 * 有效的括号
 * <p>
 * 题目来自 leetcode
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 * <p>
 * 可以使用栈的结构来解决这个问题
 */
public class EffectiveParentheses {

    public static void main(String[] args) {
        System.out.println(new EffectiveParentheses().isValid("()"));
        System.out.println(new EffectiveParentheses().isValid("(}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //  如果是符号开头那么就加入栈内
            if ('(' == c || '{' == c || '[' == c) {
                stringStack.push(c);
            } else {
                //  如果不是符号开头并且栈内为空，那么肯定说明并不能组成有效的括号
                if (stringStack.isEmpty()) {
                    return false;
                }
                //  下面是进行配对
                char topChar = stringStack.pop();
                if (')' == c && '(' != topChar) {
                    return false;
                }
                if (']' == c && '[' != topChar) {
                    return false;
                }
                if ('}' == c && '{' != topChar) {
                    return false;
                }
            }
        }
        //  如果都遍历完了，并且都为有效的括号，那么栈内应该为空
        //  如果不为空，肯定说明栈内还有一些剩余的没有匹配到的符号开头
        return stringStack.isEmpty();
    }
}
