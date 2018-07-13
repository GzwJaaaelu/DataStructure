package com.jaaaelu.gzw.learn.dataStructureAndAlgorithms.ImoocDataStructure.Arrays;

public class DynamicArray<T> {
    /**
     * 默认数组容量
     */
    private static final int DEFAULT_ARRAY_CAPACITY = 10;
    /**
     * 自定义类中的数组
     */
    private T[] data;
    /**
     * data 数组中有效元素的数量
     */
    private int size;

    /**
     * 构造函数
     *
     * @param capacity 数组的声明大小
     */
    public DynamicArray(int capacity) {
        //  Java 不支持直接 new 一个范型类型的数组
        //  需要绕一个弯
        data = (T[]) new Object[capacity];
        //  数组初始的有效元素大小为 0
        size = 0;
    }

    public DynamicArray(T[] arr) {
        data = (T[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 构造函数
     */
    public DynamicArray() {
        //  默认构造用户没有传入数组的容量大小，我们可以创建一个默认大小的数组，长度为 10
        this(DEFAULT_ARRAY_CAPACITY);
    }

    /**
     * 获取数组的有效元素数量
     *
     * @return 有效元素数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组类的容量
     *
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空（判断有效值）
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 获取对应下标的元素值
     *
     * @param index 下标
     * @return 对应值
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("大哥这个参数真的真的不合法：" + index);
        }
        return data[index];
    }

    /**
     * 向数组某个位置插入值，本来这个地方以及后面的值向后移动一位
     *
     * @param index 制定位置
     * @param value 对应值
     */
    public void add(int index, T value) {
        //  如果 Index 不合法就抛出异常
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("大哥这个参数真的真的不合法：" + index);
        }

        if (size == getCapacity()) {
            //  如果满了就扩容，大小为当前容量 * 2
            resize(2 * getCapacity());
        }

        //  每一个对应的元素向后挪一个位置
        //  但注意这里时 size - 1，而不是 data.length - 1
        //  size 才是有效元素的个数
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        //  在对应位置插入对应值
        data[index] = value;
        size++;
    }

    /**
     * 更新下标对应元素的值
     *
     * @param index 下标
     * @param value 更新后的值
     */
    public void set(int index, T value) {
        //  对应的 index 要大于零并且小于 size
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("大哥这个参数真的真的不合法：" + index);
        }
        data[index] = value;
    }

    public void addLast(T value) {
        add(size, value);
    }

    /**
     * 移除对应下标的元素值
     *
     * @param index 下标
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("大哥这个参数真的真的不合法：" + index);
        }

        T ret = data[index];

        //  删除也就是覆盖的操作，后一个覆盖前一个，从前往后
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //  最后一个没用了，可以准备被垃圾回收了
        data[size] = null;

//        //  如果数组长度小到了数组长度的二之一就缩减数组容量
//        if (size == getCapacity() / 2) {
//            resize(getCapacity() / 2);
//        }
        //  防止复杂度震荡，这里我们修改为当有效长度为容量四分之一时，才将容量减半
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    /**
     * 数组扩容
     *
     * @param newCapacity 扩容后长度
     */
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * 为了最大堆 添加的交换方法
     *
     * @param parent 父节点下标
     * @param index  该节点下标
     */
    public void swap(int parent, int index) {
        if (parent < 0 || parent >= size || index < 0 || index >= size) {
            throw new IllegalArgumentException("交换位置的下标不合法");
        }

        T t = data[parent];
        data[parent] = data[index];
        data[index] = t;
    }
}
