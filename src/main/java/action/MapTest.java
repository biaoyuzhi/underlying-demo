package action;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by wuzh on 2019/10/21.
 * Describe：
 */
public class MapTest {
    public static void main(String[] args) {
        //HashMap，初始化了loadFactor属性
        HashMap<Object, Object> map = new HashMap<>();
//        int n = 16 - 1;
//        n |= n >>> 1;               //>>>为无符号右移，等价于n = n | (n >>> 1)
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        //上面按位操作后，n一定是2的整数次方减去1（11...11全为1）
//        System.out.println((n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1);
        for (int i = 3; i < 23; i++) {
            map.put(i, String.valueOf(i));
        }
        map.put(new MapKey(null), "a");
        map.put(new MapKey("c"), "c");
        map.put(new MapKey("c1"), "c");
        map.put(new MapKey("c2"), "c");
        map.put(new MapKey("c3"), "c");
        map.put(new MapKey("c4"), "c");
        map.put(new MapKey("c5"), "c");
        map.put(new MapKey("c6"), "c");
        map.put(new MapKey("c7"), "c");
        map.put(new MapKey("c8"), "c");
        map.put(new MapKey("c9"), "c");
        map.put(new MapKey("c10"), "c");
        //测试hashcode碰撞情况
        for (int i = 0; i < 18; i++) {
            map.put(new MapKey(String.valueOf(i)), String.valueOf(i));
        }
        System.out.println(map.size());
        /**
         * 约定前面的数组结构的每一个格格称为桶
         * 约定桶后面存放的每一个数据称为bin
         * bin这个术语来自于JDK 1.8的HashMap注释。
         * table为数组结构类，Node为链表结构类，TreeNode为红黑树结构类
         * □ □     ->hashcode=1     //第一列为table结构，hashcode碰撞时往后面放(第1行和第2行有碰撞)，可能为Node结构，也可能为TreeNode结构
         * □ □ □  ->hashcode=2    //新加入的放在链头，最先加入的放在链尾
         * □        ->hashcode=3
         * □        ->hashcode=4
         * 如果一个桶采用了树形结构存储，其他桶是不是也采用树形结构存储？结论是，如果其他桶中bin的数量没有超过8或10，则用链表存储，如果超过8或10，则用树形存储，即互不影响。
         * 树化(红黑树)的情况有2种：
         * 1、capacity >= (MIN_TREEIFY_CAPACITY = 64)，并且size > (threshold = 32*0.75 = 24)，并且某个桶的bin数量 > (TREEIFY_THRESHOLD = 8)时树化。
         * 2、只向一个桶中添加bin，bin数量 > (TREEIFY_THRESHOLD = 8) 时第一次扩容capacity = 32，bin数量 > 9 时第二次扩容capacity = 64，bin数量 > 10 时树化。过程中size = bin数量
         */
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put(14,"a");
        treeMap.put(10,"b");
        treeMap.put(18,"c");
        treeMap.put(6,"d");
        treeMap.put(12,"e");
        treeMap.put(16,"f");
        treeMap.put(20,"g");
        treeMap.put(4,"h");
        treeMap.put(8,"i");

        treeMap.put(7,"j");
        Comparable k = "a";     //因为String、Integer、Character等等都实现了Comparable接口，所以可以使用多态
        /**
         * 参考https://www.jianshu.com/p/3958a1a11cb0
         * 红黑树是一棵二叉排序树。且满足以下特点：
         * 1、每个节点或者是黑色，或者是红色
         * 2、根节点是黑色
         * 3、每个叶子节点（NIL）是黑色。【注意：叶子节点是指为空(NIL或NULL)的叶子节点】
         * 4、如果一个节点是红色的，则它的两个儿子都是黑色的
         * 5、从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑色节点
         * 红黑树的插入与删除和AVL树类似，也是每插入一个结点，都检查是否破坏了树的结构，然后进行调整。红黑树每个结点插入时默认都为红色，这样做可以降低黑高，也可以减少调整的次数。
         * 在插入元素时，叔叔结点是主要影响因素，待插入结点与父结点的关系决定了是否需要多次旋转。可以总结为以下几种情况：
         * 如果父结点是黑色，插入即可，无需调整。
         * 如果叔叔结点是红色，就把父结点和叔叔结点都转为黑色，祖父结点转为红色，将不平衡向上传递。
         * 如果叔叔结点是黑色或者没有(NIL)叔叔结点，就看父结点和待插入结点的关系。如果待插入结点和父结点的关系，与父结点与祖父结点的关系一致，比如待插入结点是父结点的左孩子，父结点也是祖父结点的左孩子，就无需多次旋转。否则就先通过相应的旋转将其关系变为一致。
         *
         */
    }
    private class MyComparable implements Comparable{
        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    private class MyHashMap<K, V> extends AbstractMap<K, V>
            implements Map<K, V>, Cloneable, Serializable {
        static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;  // aka 16。capacity指HashMap中桶的数量，一定是2的幂
        static final int MAXIMUM_CAPACITY = 1 << 30;        //最大容量
        static final float DEFAULT_LOAD_FACTOR = 0.75f;     //填充比
        //当add一个元素到某个桶，如果这个桶中bin的数量大于了TREEIFY_THRESHOLD，但是capacity小于MIN_TREEIFY_CAPACITY则依然使用链表结构进行存储，此时会对HashMap进行扩容
        static final int TREEIFY_THRESHOLD = 8;
        static final int UNTREEIFY_THRESHOLD = 6;
        static final int MIN_TREEIFY_CAPACITY = 64;
        //transient HashMap.Node<K,V>[] table;      //存储（位桶）的数组</k,v>
        transient Set<Map.Entry<K, V>> entrySet;
        transient int size;         //表示HashMap中存放KV的数量（为链表和树中的KV的总和）
        transient int modCount;     //被修改的次数fast-fail机制
        int threshold;              //临界值。当HashMap的size大于threshold时会执行resize操作。threshold=capacity*loadFactor
        final float loadFactor;     //构造函数中必须赋值。计算HashMap的实时装载因子的方法为：size/capacity

        public MyHashMap() {
            this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
        }
        @Override
        public Set<Entry<K, V>> entrySet() {
            return null;
        }
    }

    private class MyTreeMap<K,V> extends AbstractMap<K,V>
            implements NavigableMap<K,V>, Cloneable, Serializable {
        private final Comparator<? super K> comparator;     //构造函数中必须赋值。比较器
//        private transient TreeMap.Entry<K,V> root;        //根节点
        private transient int size = 0;                     //entries数量
        private transient int modCount = 0;                 //结构修改的数量

        public MyTreeMap() {
            this.comparator = null;
        }
        @Override
        public Set<Entry<K, V>> entrySet() {
            return null;
        }
        @Override
        public Entry<K, V> lowerEntry(K key) {
            return null;
        }
        @Override
        public K lowerKey(K key) {
            return null;
        }
        @Override
        public Entry<K, V> floorEntry(K key) {
            return null;
        }
        @Override
        public K floorKey(K key) {
            return null;
        }
        @Override
        public Entry<K, V> ceilingEntry(K key) {
            return null;
        }
        @Override
        public K ceilingKey(K key) {
            return null;
        }
        @Override
        public Entry<K, V> higherEntry(K key) {
            return null;
        }
        @Override
        public K higherKey(K key) {
            return null;
        }
        @Override
        public Entry<K, V> firstEntry() {
            return null;
        }
        @Override
        public Entry<K, V> lastEntry() {
            return null;
        }
        @Override
        public Entry<K, V> pollFirstEntry() {
            return null;
        }
        @Override
        public Entry<K, V> pollLastEntry() {
            return null;
        }
        @Override
        public NavigableMap<K, V> descendingMap() {
            return null;
        }
        @Override
        public NavigableSet<K> navigableKeySet() {
            return null;
        }
        @Override
        public NavigableSet<K> descendingKeySet() {
            return null;
        }
        @Override
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return null;
        }
        @Override
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return null;
        }
        @Override
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return null;
        }
        @Override
        public Comparator<? super K> comparator() {
            return null;
        }
        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return null;
        }
        @Override
        public SortedMap<K, V> headMap(K toKey) {
            return null;
        }
        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            return null;
        }
        @Override
        public K firstKey() {
            return null;
        }
        @Override
        public K lastKey() {
            return null;
        }
    }
}

/**
 * 自定义一个类MapKey作为填入HashMap中元素的键，它们不相等，但是hashcode却可能相等，因为只有3个取值。用于模拟HashMap中的key碰撞情况。
 */
class MapKey {
    private static final String REG = "[0-9]+";
    private String key;

    public MapKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MapKey mapKey = (MapKey) o;
        return key != null ? key.equals(mapKey.key) : mapKey.key == null;

    }

    @Override
    public int hashCode() {     //null返回0，全阿拉伯数字形式返回1，其它形式返回2
        if (key == null)
            return 0;
        Pattern pattern = Pattern.compile(REG);
        if (pattern.matcher(key).matches())
            return 1;
        else
            return 2;
    }

    @Override
    public String toString() {
        return key;
    }
}

//       ○B-3
//     /    \
//   ○B-2   ○R-6
// /       /    \
//○R-1  ○B-4  ○B-7
//          \      \
//          ○R-5  ○R-8