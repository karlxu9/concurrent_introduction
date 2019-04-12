package dg;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/3/23 16:59
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class Role {

    public static void main(String[] args) {
        System.out.println(foo(4));
    }

    public static Integer foo(int i) {
        if (i < 0) {
            return 0;
        } else if (i <= 2) {
            return 1;
        }
        return foo(i - 1) + foo(i - 2);
    }
}
