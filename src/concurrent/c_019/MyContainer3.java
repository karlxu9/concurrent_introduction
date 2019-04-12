package concurrent.c_019;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 模块描述: <br>
 * (加上volatile，可以实现功能)
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 11:25
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class MyContainer3 {

    volatile List list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer3 c = new MyContainer3();
        final Object o = new Object();


        new Thread(() -> {
            synchronized (o) {
                if(c.size() != 5) {
                    try {
                        o.wait();
                        System.out.println("重新拿到锁");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();

        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add" + i);
                    if(c.size() == 5) {
                        o.notify();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "t1").start();

    }


}
