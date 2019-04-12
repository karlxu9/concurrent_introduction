package reflect;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/3/30 15:55
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class Robot {

    private String name;

    private void throwHello(String hello) {
        System.out.println(hello+ "throwhello :" + name);
    }

    public String sayHi(String tag) {
        return "say HI" + tag;
    }

}
