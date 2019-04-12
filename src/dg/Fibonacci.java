package dg;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模块描述: <br>
 * (斐波那契)
 *
 * @Author: Mr. xyb
 * @Date: 2019/3/30 17:59
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class Fibonacci {

    public static int fibonacci(int num) {
        if (num < 1) {
            return 0;
        } else if (num == 1) {
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    private static AtomicInteger nums = new AtomicInteger(4);

    public static void main(String[] args) {
        int num = 3;

        int fibonacci = fibonacci(nums.get());
        System.out.println(fibonacci);
        /*for (int i = 0; i < num; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    int fibonacci = fibonacci(nums.getAndIncrement());
                    System.out.println(fibonacci);
                }
            }).start();
        }*/
    }
}
