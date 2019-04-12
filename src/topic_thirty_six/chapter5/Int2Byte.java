package topic_thirty_six.chapter5;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/4 18:52
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class Int2Byte {
    byte v = 127;
    char c = 1;
    short s = 1;
    int i = 1;
    byte b2 = (byte) i;
    short s3 = 300;

    public static void main(String[] args) {
        System.out.println(new Int2Byte().b2);
        // print(50);
    }

    private static void print(byte num) {
        System.out.println(num);
    }

    void test() {
        final short s = 50;
        byte b = s;
        System.out.println(b);
    }

    /*private static void print(long l) {
        System.out.println(l);
    }*/
}
