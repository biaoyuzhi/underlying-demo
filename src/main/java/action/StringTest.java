package action;


/**
 * Created by wuzh on 2019/10/29.
 * Describe：String，native，StringBuilder,StringBuffer
 */
public class StringTest {
    //1、声明native方法
    public native int getVersion();
    //2、加载动态链接库
    static {
        System.loadLibrary("wuzh");
    }
    public static void main(String[] args) {
        String s1 = new String();
        String s2 = new String("ab");
        String s3 = new String("ab");
        String s4 = "ab";
        String s5 = "ab";
        /**
         * equals()：比较两字符串的Unicode序列是否相当
         * ==：是比较两字符串的地址是否相同，也就是是否是同一个字符串的引用
         *                  栈                   堆
         *              |------|    |---------------------------|
         *              |      |    |   0x1122(s2)              |
         * String s5  ->|0x3311|    |               0x1133(s3)  |
         * String s4  ->|0x3311|    |(它们的value指向地址0x3311)|
         * String s3  ->|0x1133|    |---------------------------|
         * String s2  ->|0x1122|    |   0x3311("ab") 常量池     |
         */
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s4 == s5);
        String s6 = new String(new int[]{97, 98, 99}, 0, 2);    //new String(new int[]{1, 2, 3}, 0, 2)返回的是""，查阅ASCII表
        System.out.println("s6:" + s6);
        boolean empty = " ".isEmpty();  //结果为false，非空
        //3、调用native方法
        int version = new StringTest().getVersion();
        System.out.println("+++++++++++:" + version);
        /**
         * native的使用参考：https://blog.csdn.net/zw6161080123/article/details/80628069
         * 针对.class文件，生成头文件命令：javah -classpath E:/IntelliJIDEAWorkSpace/underlying-demo/target/classes action.StringTest
         * 再编写JNI文件(.cpp)，最后使用某些工具(eg:Visual Studio)生成.dll文件，即动态链接库
         */
        //StringBuilder构造器和大量的方法都是直接调用父类AbstractStringBuilder的方法。底层也是char[] value
        StringBuilder builder = new StringBuilder();
        //StringBuffer类似StringBuilder，其构造器和大量的方法也是直接调用父类AbstractStringBuilder的方法。
        //除了构造器外，重写父类的方法中大多是只增加了同步锁synchronized，实现部分直接调用父类同一方法。
        StringBuffer buffer = new StringBuffer();
    }
}
final class MyString implements java.io.Serializable, Comparable<String>, CharSequence{
    private final char value[];
    private int hash; // Default to 0

    public MyString(){
        this.value = new MyString().value;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
