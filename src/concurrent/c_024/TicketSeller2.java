package concurrent.c_024;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 模块描述: <br>
 * (使用Vector依旧会出现问题)
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 15:30
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class TicketSeller2 {

    /**
     * 使用Vector依旧会出现问题
     */
    static List<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("销售了--" + tickets.remove(0));
                }
            }).start();
        }
    }

}
