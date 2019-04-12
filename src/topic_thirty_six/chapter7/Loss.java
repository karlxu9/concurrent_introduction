package topic_thirty_six.chapter7;

/**
 * 模块描述: <br>
 * (计算floag从哪个数字开始失去精度)
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/4 21:37
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class Loss {

    public static void main(String[] args) {
        float start = 0f;
        float next = Math.nextUp(start);
        while (next + 1 != next) {
            next = Math.nextUp(next);
        }
        System.out.println(next);
    }

}
