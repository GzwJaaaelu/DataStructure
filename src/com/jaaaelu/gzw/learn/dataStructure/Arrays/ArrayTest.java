package com.jaaaelu.gzw.learn.dataStructure.Arrays;

public class ArrayTest {

    public static void main(String[] args) {

        testArray();
        System.out.println("---------------------------------------------");
        testDynamicArray();
  }

    private static void sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += sum;
        }
    }

    private static void testArray() {
        Array<Integer> array = new Array<>(5);

        array.addLast(1);
        array.addLast(2);
        array.addLast(4);

        System.out.println(array);

        array.add(2, 3);

        System.out.println(array);

        array.add(0, 0);

        System.out.println(array);

        array.set(0, -1);

        System.out.println(array);

        array.remove(1);
        array.removeFirst();
        array.removeLast();

        System.out.println(array);

        System.out.println("Get index 1 -> " + array.get(1));
//        System.out.println("Get index 5 -> " + array.get(5));

    }

    private static void testDynamicArray() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(1);
        dynamicArray.add(0, 1);
        System.out.println("dynamicArray capacity - > " + dynamicArray.getCapacity());
        dynamicArray.add(1, 2);
        System.out.println("dynamicArray capacity - > " + dynamicArray.getCapacity());
        dynamicArray.add(2, 3);
        System.out.println("dynamicArray capacity - > " + dynamicArray.getCapacity());
        dynamicArray.remove(0);
        System.out.println("dynamicArray capacity - > " + dynamicArray.getCapacity());;
    }
}
