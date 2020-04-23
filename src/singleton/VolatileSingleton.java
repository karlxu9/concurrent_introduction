package singleton;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. KarlXu
 * @Date: 2020/4/24 0:30
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class VolatileSingleton {

    public volatile static VolatileSingleton volatileSingleton = null;

    public static VolatileSingleton getInstance() {
        if (volatileSingleton == null) {
            synchronized (VolatileSingleton.class) {
                if (volatileSingleton == null) {
                    return volatileSingleton = new VolatileSingleton();
                }
            }
        }
        return volatileSingleton;
    }


}
