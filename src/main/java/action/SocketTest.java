package action;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wuzh on 2019/11/19.
 * Describe: 浏览器端直接访问ip:80即可。发现下面参数堵塞方法使得线程池不会提前运行子线程，否则程序启动后会第一时间创建nThreads个子线程
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = new ServerSocket(80);   //带参数的ServerSocket底层实现了bind方法，如果不带参数，则需要自己调用bind方法
        while (true){
            System.out.println("线程运行前");
            threadPool.execute(new Dispatcher(serverSocket.accept()));  //堵塞在参数上了，所以ServerSocket被访问前，线程池并没有执行
        }
    }
}
class Dispatcher implements Runnable{
    private Socket client;
    public Dispatcher(Socket client){
        this.client = client;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程运行后");
    }
}
