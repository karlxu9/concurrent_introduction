package concurrent.c_010;

/**
 * 模块描述: <br>
 * (synchronized是可重入锁，子类调用父类的方法)
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 9:10
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T {

    public synchronized void m1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2...");
    }

    public static void main(String[] args) {
        T t = new TT();
        t.m1();
    }

}

class TT extends T {
    @Override
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "Child m1 start");
        super.m1();
        System.out.println("Child m1 end");

    }
}