/**
 * Created by IntelliJ IDEA.
 *
 * @Avatar: xyb
 * Date: 2017/9/4
 * Time: 14:54
 * To change this template use File | Settings | File Templates.
 */

package singleton;

/**
 * @Author: xyb
 * @Time: 14:54
 * @Version: 2017/9/4
 * <p>
 * <p>
 * 公共域，利用工厂模式可以添加业务逻辑代码
 * To change this template use File | Settings | File Templates.
 */
public class SingletonDemo3 {

    private static final SingletonDemo3 INSTANCE = new SingletonDemo3();

    private SingletonDemo3() {
    }

    public static SingletonDemo3 getInstance() {
        return INSTANCE;
    }

}
