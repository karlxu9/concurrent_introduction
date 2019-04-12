package concurrent.c_023;

import java.util.Arrays;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 15:20
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class Singleton {
    public Singleton() {
        System.out.println("Singleton");
    }

    private static class Inner {
        private static Singleton singleton = new Singleton();
    }

    private static Singleton getInstance() {
        System.out.println(Inner.singleton);
        return Inner.singleton;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                Singleton.getInstance();
            });
        }
        Arrays.asList(threads).forEach(o -> o.start());
    }
}
