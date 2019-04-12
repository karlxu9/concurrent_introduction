package topic_thirty_six.chapter6;

import java.math.BigDecimal;

/**
 * 模块描述: <br>
 * (精确的标识浮点数)
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/4 18:52
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class FloatStorage2 {
    public static void main(String[] args) {
        int limit = 9999;
        int length = String.valueOf(limit).length();
        System.out.println(length);
        System.out.println("0.0001~0.9999之间烤鱼使用二进制来准确标识的小数有：");
        for (int i = 0; i <= limit; i++) {
            int num0 = length - String.valueOf(i).length();
            StringBuilder value = new StringBuilder("0.");
            for (int j = 0; j < num0; j++) {
                value.append("0");
            }
            value.append(i);
            BigDecimal db = new BigDecimal(Double.parseDouble(value.toString()));
            if (db.scale() <= length) {
                System.out.println(db);
            }
        }

        float f1 = 100000000;
        float f2 = 100000001;
        System.out.println(f1 == f2);

        double d1 = 10019999999999.1d;
        double d2 = 10019999999999d;
        System.out.println(d1 == d2);
    }
}
