/**
 * Created by IntelliJ IDEA.
 *
 * @Avatar: xyb
 * Date: 2017/9/4
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */

package thread;

/**
 * @Author: xyb
 * @Time: 15:07
 * @Version: 2017/9/4
 * To change this template use File | Settings | File Templates.
 */
public class ThreadDemo1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程 " + Thread.currentThread().getName() + "--" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadDemo1());
        thread.start();
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        thread.join();
        System.out.println(Thread.currentThread().getName());
    }
}
