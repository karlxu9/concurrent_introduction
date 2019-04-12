/**
 * 对比上一个程序，可以用synchronized解决，synchronized可以保证可见性和原子性，volatile只能保证可见性
 */
package concurrent.c_016;

import java.util.ArrayList;
import java.util.List;


public class T {
    /*volatile*/ int count = 0;

    synchronized void m1() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        for (int i = 0; i < 100000; i++) {
            count++;
        }
        /*try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }


    void m2() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        synchronized (this) {
            for (int i = 0; i < 100000; i++) {
                count++;
            }
        }
        /*try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public static void main(String[] args) {
        T t = new T();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(t::m1, "T1");
            threads.add(t1);
        }
        long start = System.currentTimeMillis();
        threads.forEach(o -> o.start());
        threads.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();
        System.out.println(end - start + "," + t.count);

        threads.clear();
        t.count = 0;
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(t::m2, "T2");
            threads.add(t1);
        }
        start = System.currentTimeMillis();
        threads.forEach(o -> o.start());
        threads.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        end = System.currentTimeMillis();
        System.out.println(end - start + "," + t.count);
    }

}
