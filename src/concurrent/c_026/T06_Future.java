package concurrent.c_026;

import concurrent.c_010.T;

import java.util.concurrent.*;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/13 0:54
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T06_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(() -> {
            TimeUnit.SECONDS.sleep(2);
            return 100;
        });

        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return 1;
        });

        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());
    }
}
