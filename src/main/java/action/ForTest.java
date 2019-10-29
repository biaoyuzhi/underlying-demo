package action;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wuzh on 2019/10/29.
 * Describe：普通for循环和增强型for循环
 */
public class ForTest {
    public static void main(String[] args) {
        /**
         * 用javap -c看下两个类的字节码操作
         * 通过编译后的字节码可以看出，数组的for-each和普通的for循环底层原理是一样的，都是用的普通for循环的那一套。
         * 数组的for-each比普通for循环多一点点操作，理论上是要慢一点点，这个暂时也不知道是为什么。这也是语法糖的一些代价，语法越简单，反而越不好进行底层优化。
         * 不过这个慢一点那真是一点，在循环体比较复杂时，这个差距就更小了，所以基本上可以认为这两种方式效率一样。
         * 实际中根据自己的情况选择，如果需要显式使用下标，就用传统for循环，其他的都可以使用for-each循环。
         */
        int arr[] = {2,5,7,9};
        for (int i = 0; i < arr.length;i++){
            System.out.println(arr[i]);
        }
        for (int aa : arr) {
            System.out.println(aa);
        }

        /**
         * 集合框架中的三种迭代方式删除数据
         * 1.普通for循环,可以删除,注意让索引做自减运算
         * 2.迭代器,可以删除,但是必须使用迭代器自身的remove方法,否则会出现并发修改异常
         * 3.增强for循环不能删除
         */
        /**
         * 看Iterable接口的注释，它说明了除了数组外，其他类想要使用for-each循环必须实现这个接口。这一点表明除了数组外的for-each可能底层是由迭代器实现的。
         * 字节码自带的注释都说了，Collection的for-each底层也是使用迭代器来实现的，两种方式可以说是完全等价的。
         * 对于ArrayList这种，在cpu密集型的应用中应该只使用传统for循环，在循环体执行时间比较长的应用中，传统for循环和迭代器循环的差别就很小了，这时候使用迭代器（for-each循环）也不会明显降低执行效率。
         */
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        for (int i = list.size()-1; i >= 0;i--){
            System.err.println(list.get(i));
            list.remove(i);
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.err.println(iterator.next());
            iterator.remove();
        }
        for (String obj : list){
            System.out.println(obj);
            list.remove(obj);   //这个移除只会发生1次
        }
//        for (String obj : list){
//            System.out.println(obj);
//        }
    }
}
