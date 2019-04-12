package concurrent.c_025;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 15:57
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T01_ConcurrentMap {

    public static void main(String[] args) {
        // Map<String, String> map = new ConcurrentHashMap<>();
        // Map<String, String> map = new ConcurrentSkipListMap<>();
        // Map<String, String> map = new HashMap<>();
        Map<String, String> map = new Hashtable<>();
        Random r = new Random();
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    map.put("a" + r.nextInt(100000), "a" + r.nextInt(100000));
                }
                latch.countDown();
            });
        }
        Arrays.asList(threads).forEach(o -> o.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
