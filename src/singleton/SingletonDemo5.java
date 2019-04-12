package singleton;

import java.util.Arrays;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/11 12:41
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class SingletonDemo5 {

    public SingletonDemo5() {
        System.out.println("single");

    }

    public static class Inner {
        private static SingletonDemo5 singletonDemo5 = new SingletonDemo5();
    }

    private static SingletonDemo5 get() {
        return Inner.singletonDemo5;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                System.out.println(get());
            });
        }

        Arrays.asList(threads).forEach(o -> o.start());

    }

}
