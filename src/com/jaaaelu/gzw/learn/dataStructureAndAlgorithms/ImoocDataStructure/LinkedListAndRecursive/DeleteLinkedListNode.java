package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.LinkedListAndRecursive;

/**
 * 删除链表中的节点
 * <p>
 * 题目来自 leetcode
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 * <p>
 * 使用链表解决这个问题
 */
public class DeleteLinkedListNode {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        //  不使用虚拟头节点
        //  处理链表开头的位置有需要删除元素
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        //  处理链表中间
        ListNode preNode = head;
        while (preNode.next != null) {
            if (preNode.next.val == val) {
                ListNode delNode = preNode.next;
                preNode.next = delNode.next;
                delNode.next = null;
            } else {
                preNode = preNode.next;
            }
        }
        return head;
    }


    public ListNode removeElementsWithDummyHead(ListNode head, int val) {
        //  使用虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode preNode = dummyHead;
        while (preNode.next != null) {
            if (preNode.next.val == val) {
                ListNode delNode = preNode.next;
                preNode.next = delNode.next;
                delNode.next = null;
            } else {
                preNode = preNode.next;
            }
        }
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        // 链表节点的构造函数
        // 使用arr为参数，创建一个链表，当前的ListNode为链表头结点
        ListNode(int[] arr) {

            if (arr == null || arr.length == 0)
                throw new IllegalArgumentException("arr can not be empty");

            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        // 以当前节点为头结点的链表信息字符串
        @Override
        public String toString() {

            StringBuilder s = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                s.append(cur.val).append("->");
                cur = cur.next;
            }
            s.append("NULL");
            return s.toString();
        }
    }


    public ListNode removeElementsByRecursive(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //  我写错误逻辑
//        if (head.val == val) {
//            head = head.next;
//            return removeElementsByRecursive(head, val);
//        } else {
//            return removeElementsByRecursive(head.next, val);
//        }
        //  老师的答案
//        ListNode res = removeElementsByRecursive(head.next, val);
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }
        //  化简的答案
        head.next = removeElementsByRecursive(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 在实现功能的基础上学习如何进行调试递归函数
     *
     * @param head  要操作的链表的头部
     * @param val   要删除的值
     * @param depth 递归深度，每调用一次自己，深度 +1
     * @return 删除后的链表
     */
    public ListNode removeElementsByRecursiveWithTest(ListNode head, int val, int depth) {
        String depthSting = generateDepthString(depth);
        System.out.print(depthSting);
        System.out.println("Call: remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthSting);
            System.out.println("Return null");
            return null;
        }
        //  暂存调用结果
        ListNode res = removeElementsByRecursiveWithTest(head.next, val, depth + 1);
        System.out.print(depthSting);
        System.out.println("After remove " + val + " : " + res);
        //  最终返回结果
        ListNode returnResult;
        if (head.val == val) {
            returnResult = res;
        } else {
            head.next = res;
            returnResult = head;
        }
        System.out.print(depthSting);
        System.out.println("Return " + returnResult);
        return returnResult;
    }

    private String generateDepthString(int depth) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            builder.append("-- ");
        }
        return builder.toString();
    }
}
