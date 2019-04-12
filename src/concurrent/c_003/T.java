package concurrent.c_003;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 9:10
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T {

    private Integer count = 10;


    synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + "-----" + "count:" + count);
    }

    public static void main(String[] args) {
        T t = new T();
        t.m();
    }

}
