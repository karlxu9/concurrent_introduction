package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/3/13 10:45
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap();
        map.put("test", "ssss");
        String test = (String) map.get("test");
        System.out.println(test);
    }

}
