package concurrent.c_026;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/13 0:12
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T01_MyExecutor implements Executor {

    public static void main(String[] args) {
        new T01_MyExecutor().execute(() -> System.out.println("hello executor"));
    }

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
