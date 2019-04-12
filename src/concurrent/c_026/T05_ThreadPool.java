package concurrent.c_026;

import java.util.concurrent.*;

/**
 * 模块描述: <br>
 * (普通线程池)
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/13 0:27
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T05_ThreadPool {
    public static void main(String[] args) {
        /*ExecutorService service = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());*/
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);

        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);


    }
}
