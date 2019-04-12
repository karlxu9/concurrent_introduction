package concurrent.c_012;

import java.util.concurrent.TimeUnit;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 9:53
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T {

    boolean running = true;

    void m() {
        System.out.println("m start");
        while (running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("m2 end");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m, "t1").start();
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        t.running = false;
    }


}
