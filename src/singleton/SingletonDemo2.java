/**
 * Created by IntelliJ IDEA.
 *
 * @Avatar: xyb
 * Date: 2017/9/4
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */

package singleton;

/**
 * @Author: xyb
 * @Time: 14:51
 * @Version: 2017/9/4
 *
 * 公共域方式的单例
 * To change this template use File | Settings | File Templates.
 */
public class SingletonDemo2 {

    public static final SingletonDemo2 INSTANCE = new SingletonDemo2();

    private SingletonDemo2() {}

}
