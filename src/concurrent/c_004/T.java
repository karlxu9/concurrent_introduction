package concurrent.c_004;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 9:10
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T {

    private static Integer count = 10;


    public static synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + "-----" + "count:" + count);
    }

    public static void mm() {
        synchronized (T.class) {
            count--;
        }
    }

    public static void main(String[] args) {
        new Thread(() -> T.m()).start();
        new Thread(() -> T.mm()).start();
    }

}
