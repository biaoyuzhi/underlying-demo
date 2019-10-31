package action;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by wuzh on 2019/10/30.
 * Describe: FileReader
 */
public class IOTest {
    public static void main(String[] args) throws IOException {
        /**
         * FileReader类只定义了三个构造器，将参数转换为FileInputStream后均调用父类的InputStreamReader(InputStream in)构造器。
         * 创建一个文件字符流。本质是用InputStreamReader、StreamDecoder对FileInputStream进行装饰。
         * 装饰模式——谁被放在了构造器的参数中，谁就是被装饰者。所以FileInputStream是被装饰者，FileReader是装饰者。
         *
         * 查看StreamDecoder源码时是.class文件，原因：StreamDecoder类来自于sun包，jdk目录下是有源码的，但是源码不包含sun包，但是openjdk网站有提供。
         * 解决办法：在openjdk网站下载新的源码包，再File->Project Structure...->SDKs->Sourcepath选项卡中添加新的源码包路径
         *
         * StreamDecoder类是字节流到字符流的解码器，而StreamDecoder类的int read(char cbuf[], int offset, int length)方法是解码核心
         * int n = readBytes()读取字节到字节缓冲区bb中，返回值n为读入缓冲区的字节总数，如果上次读取到达末尾，这次再读将返回-1
         * CoderResult cr = decoder.decode(bb, cb, eof)将字节缓冲区bb内容解码到字符缓冲区cb中，返回值cr为解码结果码
         * 解码的底层是CharsetDecoder类的cr = decodeLoop(in, out)方法，而该方法是抽象方法，需要子类去重写，所以它的子类需要根据当前使用的编码方式来确定。
         * InputStreamReader获得StreamDecoder类的时候就已经确定了编码方式。
         * ASCII码为负数的是中文字符，连续3个负数为一个中文字符。UTF_8类的decodeArrayLoop(ByteBuffer src,CharBuffer dst)方法为ASCII码解码过程
         *
         * InputStreamReader 是字节流通向字符流的桥梁
         * 从字节到字符的解码过程严重依赖StreamDecoder类及其方法
         * 它使用指定的 charset 读取字节并将其解码为字符。
         * 它使用的字符集可以由名称指定或显式给定，或者可以接受平台默认的字符集。
         * 每次调用 InputStreamReader 中的一个 read() 方法都会导致从底层输入流读取一个或多个字节。
         * 要启用从字节到字符的有效转换，可以提前从底层流读取更多的字节，使其超过满足当前读取操作所需的字节。
         */
        FileReader reader = new FileReader("C:/Users/lenovo/Desktop/1.sql");
        char[] chars = new char[8192];
        int len;
        while ((len = reader.read(chars)) != -1){
            //这里打印不换行，不然可能会破坏原有文件的排版
            System.out.print(new String(chars,0,len));
        }
        reader.close();
    }
}
