package concurrent.c_025;

import java.util.concurrent.LinkedTransferQueue;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 17:10
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T08_TransferQueue {

    public static void main(String[] args) {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        /**
         * transfer需要有消费者提前订阅，否则一直阻塞
         */
        try {
            strs.transfer("aaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // strs.put("aaa");

        /*new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/
    }
}
