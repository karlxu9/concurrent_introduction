/**
 * Created by IntelliJ IDEA.
 *
 * @Avatar: xyb
 * Date: 2017/9/4
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 */

package singleton;

/**
 * @Author: xyb
 * @Time: 14:46
 * @Version: 2017/9/4
 *
 * 最常用的单例模式
 * To change this template use File | Settings | File Templates.
 */
public class SingletonDemo1 {

    private static SingletonDemo1 singletonDemo1 = null;

    public SingletonDemo1() {
    }

    public static SingletonDemo1 getInstance() {
        if (singletonDemo1 == null) {
            singletonDemo1 = new SingletonDemo1();
        }
        return singletonDemo1;
    }

}
