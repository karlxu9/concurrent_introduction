package concurrent.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 模块描述: <br>
 * (将线程不安全的集合封装成线程安全)
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/12 16:41
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class T03_SynchronizedList {

    List list = new ArrayList<>();
    List synchronizedList = Collections.synchronizedList(list);
}
