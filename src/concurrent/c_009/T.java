package concurrent.c_009;

/**
 * 模块描述: <br>
 * (synchronized是可重入锁)
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 9:10
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T {


    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }

    public synchronized void m2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2...");
    }

    public static void main(String[] args) {
        T t = new T();
        // new Thread(t::m1, "t1").start();
        t.m1();
    }

}
