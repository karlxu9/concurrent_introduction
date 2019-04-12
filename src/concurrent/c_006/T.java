package concurrent.c_006;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 9:10
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T implements Runnable {

    private static Integer count = 10;


    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 5; i++) {
            new Thread(t, Thread.currentThread().getName()).start();
        }
    }

    /**
     * 加锁，打印规则
     */
    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + "-----" + "count=" + count);
    }
}
