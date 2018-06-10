package com.jaaaelu.gzw.learn.dataStructure.arrays;

/**
 * 自定义的数组类，支持增删改查
 */
public class Array<T>{
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
    public Array(int capacity) {
        //  Java 不支持直接 new 一个范型类型的数组
        //  需要绕一个弯
        data = (T[]) new Object[capacity];
        //  数组初始的有效元素大小为 0
        size = 0;
    }

    /**
     * 构造函数
     */
    public Array() {
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
     * 向数组头插入元素
     *
     * @param value 向数组头插入元素
     */
    public void addFirst(T value) {
        add(0, value);
    }

    /**
     * 向组数最后位置插入有效值，而 size 的值永远指向最后一位 -1
     *
     * @param value 插入的值
     */
    public void addLast(T value) {
//        checkArrayLength();
//        //  向当前 size 的索引处添加元素，并且 size++
//        //  比如 size 为 0 时，索引 0 出没有有效值
//        //  所以直接向 0 插入数据即可，然后自加后下次向 1 的位置插入值
//        //  当然这两句可以合并
//        data[size] = value;
//        size++;
//        System.out.println("走到这里 size -> " + size);

        //  写了 add 逻辑后我们可以直接调用 add 来进行简化
        add(size, value);
    }

    /**
     * 向数组某个位置插入值，本来这个地方以及后面的值向后移动一位
     *
     * @param index 制定位置
     * @param value 对应值
     */
    public void add(int index, T value) {
        checkArrayLength();
        checkArrayIndex(index);

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
     * 移除对应下标的元素值
     *
     * @param index 下标
     */
    public void remove(int index) {
        checkArrayIndexTypeTwo(index);

        //  删除也就是覆盖的操作，后一个覆盖前一个，从前往后
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //  最后一个没用了，可以准备被垃圾回收了
        data[size] = null;
    }

    /**
     * 移除下标为 0 的对应元素
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 移除最后一个有效元素
     */
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * 删除制定元素，先找下标然后删除
     * 如果 value 存在多个，这个方法只删除第一次出现的
     *
     * @param value 要删除的元素值
     */
    public void removeElement(T value) {
        int index = find(value);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 获取对应下标的元素值
     *
     * @param index 下标
     * @return 对应值
     */
    public T get(int index) {
        checkArrayIndexTypeTwo(index);
        return data[index];
    }

    /**
     * 更新下标对应元素的值
     *
     * @param index 下标
     * @param value 更新后的值
     */
    public void set(int index, T value) {
        checkArrayIndexTypeTwo(index);
        data[index] = value;
    }

    /**
     * 检查传进来索引值是否合法
     *
     * @param index 索引值
     */
    private void checkArrayIndex(int index) {
        //  对应的 index 要大于零并且小于等于 size
        //  如果等于 size 就相当于添加到最后
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("大哥这个参数真的真的不合法：" + index);
        }
    }

    /**
     * 检查传进来索引值是否合法
     *
     * @param index 索引值
     */
    private void checkArrayIndexTypeTwo(int index) {
        //  对应的 index 要大于零并且小于 size
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("大哥这个参数真的真的不合法：" + index);
        }
    }


    /**
     * 检查数组长度
     */
    private void checkArrayLength() {
        if (size == getCapacity()) {
            //  如果 size 等于了声明的容量大小，就说明没地方了，直接抛出异常
            throw new IndexOutOfBoundsException("大哥没有地方放数据了，当前数组大小 " + this.size + "，总容量为 " + getCapacity());
        }
    }

    /**
     * 是否包含某个元素
     *
     * @param value 要查找的值
     * @return 是否包含在数组中
     */
    public boolean contains(T value) {
//        for (int i = 0; i < size; i++) {
//            if (data[i] == value) {
//                return true;
//            }
//        }
//        return false;
        //  简化
        return find(value) != -1;
    }

    /**
     * 查看对应元素值的下标
     * 如果 value 存在多个，这个方法只返回第一次出现的下标值
     *
     * @param value 元素值
     * @return 元素值对应的下标，如果数组中不存在对应元素值，则返回 -1
     */
    public int find(T value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        return getArrayStr();
    }

    /**
     * 获取有些的打印内容
     *
     * @return 有效的数组内容打印
     */
    private String getArrayStr() {
        StringBuilder arrStr = new StringBuilder();
        arrStr.append(String.format("Array：size = %d，capacity = %d", size, getCapacity()));
        arrStr.append("\n");
        arrStr.append("[");
        for (int i = 0; i < size; i++) {
            arrStr.append(data[i]);
            if (i != size - 1) {
                arrStr.append(",");
            }
        }
        arrStr.append("]");
        return arrStr.toString();
    }
}
