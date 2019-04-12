package concurrent.c_005;

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
     * 不加锁，还没来得及打印就减了几次
     */
    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + "-----" + "count=" + count);
    }
}
