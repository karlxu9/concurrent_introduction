package thread;

/**
 * @Author: xyb
 * @Time: 15:09
 * @Version: 2017/9/4
 * 多线程的使用
 * 如何做让当前线程执行完毕在执行后面的线程
 * To change this template use File | Settings | File Templates.
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        /*Thread thread = new Thread(new ThreadDemo1());
        thread.start();
        // 执行此方法可以让当前线程执行完毕在执行后面的线程
        thread.join();
        new Thread(new ThreadDemo1()).start();*/

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    int n = 0;
                    for (int j = 0; j < 1000; j++) {
                        System.out.println(Thread.currentThread() + " " + (++n));
                    }
                }
            }).start();
        }
    }

}
