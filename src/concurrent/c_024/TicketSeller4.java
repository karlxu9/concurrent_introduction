package concurrent.c_024;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 模块描述: <br>
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 15:30
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class TicketSeller4 {

    /**
     * 使用ConcurrentQueue提高并发性
     */
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 100880; i++) {
            tickets.add("票编号" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    String poll = tickets.poll();
                    if (poll == null) {
                        break;
                    }
                    System.out.println("销售了：" + poll);
                }
            }).start();
        }
    }
}
