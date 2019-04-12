/**
 * Created by IntelliJ IDEA.
 *
 * @Avatar: xyb
 * Date: 2017/9/4
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */

package singleton;

/**
 * @Author: xyb
 * @Time: 14:59
 * @Version: 2017/9/4
 * To change this template use File | Settings | File Templates.
 */
public class TestSingleton {

    public TestSingleton() {

    }

    public static void main(String[] args) {
        System.out.println("singleton1" + SingletonDemo1.getInstance());
        System.out.println("singleton1" + SingletonDemo1.getInstance());


        System.out.println("singleton2" + SingletonDemo2.INSTANCE);
        System.out.println("singleton2" + SingletonDemo2.INSTANCE);

        System.out.println("singleton3" + SingletonDemo3.getInstance());
        System.out.println("singleton3" + SingletonDemo3.getInstance());

        System.out.println("singleton4" + SingletonDemo4.INSTANCE);
        System.out.println("singleton4" + SingletonDemo4.INSTANCE);
        SingletonDemo4.say("xyb");
        System.out.println("singleton5" + VolatileSingleton.getInstance());
        System.out.println("singleton5" + VolatileSingleton.getInstance());

        for (int i = 0; i < 100; i++) {
            int num = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("singleton5 - " + " " + num + VolatileSingleton.getInstance());
                }
            }).start();
        }
    }

}
