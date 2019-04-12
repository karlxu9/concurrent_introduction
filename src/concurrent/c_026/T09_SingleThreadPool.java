package concurrent.c_026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/13 1:27
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T09_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "," + j);
            });
        }
    }
}
