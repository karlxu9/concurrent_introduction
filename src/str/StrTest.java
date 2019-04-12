package str;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/3/20 9:16
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class StrTest {

    private final static StringBuilder aa = new StringBuilder("static");

    public static void main(String[] args) {
        HashSet<StringBuilder> hs = new HashSet<StringBuilder>();
        StringBuilder sb1 = new StringBuilder("aaa");
        StringBuilder sb2 = new StringBuilder("aaabbb");
        hs.add(sb1);
        hs.add(sb2);    //这时候HashSet里是{"aaa","aaabbb"}

        StringBuilder sb3 = sb1;
        sb3.append("bbb");  //这时候HashSet里是{"aaabbb","aaabbb"}
        System.out.println(hs);

        StrTest strTest = new ss();
        System.out.println(strTest.eat());

        aa.append("aa");
        System.out.println(aa.toString());
    }

    public String eat() {
        return "zzz";
    }
}


class ss extends StrTest {
    @Override
    public String eat() {
        return "aaa";
    }
}

class ee extends StrTest {
    @Override
    public String eat() {
        return "eee";
    }
}