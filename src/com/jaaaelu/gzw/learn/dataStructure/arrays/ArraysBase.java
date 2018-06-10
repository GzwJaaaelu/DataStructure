package com.jaaaelu.gzw.learn.dataStructure.arrays;

public class ArraysBase {
    //  数组基础
    //  把数据码成一排进行存放

    //  索引可以有语意也可以没有语意
    //  但身份证号并不适合做索引，还是学号方便，身份证太大了

    //  数组最大的优点：快速查询
    //  比如：scores[2]

    //  如果索引没有语意，如何表示没有值的元素
    //  如何添加元素  如何删除元素
    //  上面的问题我们需要自己基于 Java 自己封装自己的数组

    public static void main(String[] args) {

        createIntArrayTypeOne();
        createIntArrayTypeTwo();

    }

    private static void createIntArrayTypeOne() {
        //  创建 int 数组，长度为 10，后续进行赋值，默认为 0
        int[] arrInt = new int[10];

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = i;
        }

        System.out.println(java.util.Arrays.toString(arrInt));
    }

    private static void createIntArrayTypeTwo() {
        //  创建一个长度为 3 的 int 数组，并设置好对应的值
        int[] scores = new int[] {100, 98, 99};
        //  修改下标为 0 的元素的值
        scores[0] = 90;

        for (int score : scores) {
            System.out.println("成绩为 " + score);
        }
    }
}
