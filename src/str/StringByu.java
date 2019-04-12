package str;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/10 10:21
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class StringByu {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("aa");
        StringBuilder sb2 = sb;
        sb2.append("bb");
        System.out.println(sb);
    }
}
