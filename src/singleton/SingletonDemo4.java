/**
 * Created by IntelliJ IDEA.
 *
 * @Avatar: xyb
 * Date: 2017/9/4
 * Time: 14:57
 * To change this template use File | Settings | File Templates.
 */

package singleton;

/**
 * @Author: xyb
 * @Time: 14:57
 * @Version: 2017/9/4
 *
 *
 * 使用枚举的方式创建单例模式
 * To change this template use File | Settings | File Templates.
 */
public enum SingletonDemo4 {
    INSTANCE;

    public static void say(String str) {
        System.out.println("say test..." + str);
    }
}
