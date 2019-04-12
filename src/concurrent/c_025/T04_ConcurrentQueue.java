package concurrent.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 16:43
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T04_ConcurrentQueue {

    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            strs.offer("a=" + i);
        }
        System.out.println(strs);

        System.out.println(strs.size());

        // 取出第一个元素，然后从队列中移除
        System.out.println(strs.poll());
        System.out.println(strs.size());

        // 取出第一个元素，不移除
        System.out.println(strs.peek());
        System.out.println(strs.size());
    }

}
