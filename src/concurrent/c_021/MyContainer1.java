package concurrent.c_021;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 模块描述: <br>
 * (生产者消费者)
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 12:52
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class MyContainer1<T> {
    private int count = 0;
    final LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;

    private synchronized void put(T t) {
        while (list.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ++count;
        list.add(t);
        this.notifyAll();
    }

    private synchronized T get() {
        T t = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        MyContainer1<String> c = new MyContainer1();
        //启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) System.out.println(c.get());
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) c.put(Thread.currentThread().getName() + " " + j);
            }, "p" + i).start();
        }
    }
}
