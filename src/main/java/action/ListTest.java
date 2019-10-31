package action;

import java.util.*;

/**
 * Created by wuzh on 2019/10/21.
 * Describe：ArrayList和Vector
 * 为什么数组长度的最大值是MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8
 * 数组作为一个对象，需要一定的内存存储对象头信息，对象头信息最大占用内存不可超过8字节。
 * 在hotspot虚拟机中，对象在内存的分布分为3个部分，对象头，实例数据，和对齐填充。
 * 对象头包括两部分：Mark Word 和 类型指针。均为 4 字节
 */
public class ListTest {

    public static void main(String[] args) {
        //ArrayList，初始化时elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA
        ArrayList<String> list = new ArrayList<>();
        //第一次调用add方法的时候，集合被扩容Math.max(DEFAULT_CAPACITY, size+1);
        list.add("aaa");
        int newCapacity = 10 + (10 >> 1);
        System.out.println(newCapacity);

        //Vector，初始化时elementData[10]容量已经是10了，但是vector.size()返回的是elementCount
        Vector<Object> vector = new Vector<>();
        //vector每个对外暴露的方法几乎都带同步锁
        //add方法elementCount被自增1，如果元素个数>10，集合扩容int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
        //集合初始化时capacityIncrement不指定则为0
        vector.add("bbb");
        System.out.println(vector.size());
        int newCapacity2 = 10 + ((0 > 0) ? 0 : 10);
        System.out.println(newCapacity2);
    }

    private class MyArrayList<E> extends AbstractList<E>
            implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
        private final int DEFAULT_CAPACITY = 10;
        private final Object[] EMPTY_ELEMENTDATA = {};
        private final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
        transient Object[] elementData;
        private int size;

        @Override
        public E get(int index) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }

    private class MyVector<E> extends AbstractList<E>
            implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
        protected Object[] elementData;
        protected int elementCount;
        protected int capacityIncrement;

        @Override
        public E get(int index) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }
}
