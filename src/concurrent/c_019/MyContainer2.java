package concurrent.c_019;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 模块描述: <br>
 * (加上volatile，可以实现功能，但是t2是死循环很耗费资源)
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 11:25
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class MyContainer2 {

    volatile List list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer2 c = new MyContainer2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                if (c.size() == 5) {
                    break;
                }
                // System.out.println(c);
            }
            System.out.println("t2 结束");
        }, "t2").start();
    }


}
