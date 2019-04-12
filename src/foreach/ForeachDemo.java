package foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/3/12 16:11
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class ForeachDemo {

    /**
     * 删除指定元素
     */
    private static void removeStr() {
        List<String> list = new ArrayList<String>() {{
            add("Hooo");
            add("Hqqq");
            add("Hxxxx");
            add("H");
        }};
        /**
         * 使用此方法删除元素会抛Exception in thread "main" java.util.ConcurrentModificationException异常
         * 原因：在使用for增强时，使用的是Iterator进行列表遍历，而此时如果使用list自带的remove方法，会修改List的成员变量modCount，
         * 可是remove方法并不会修改expectedModCount参数，因此导致两个参数不相等，故而抛出异常
         *
         * 抛异常关键代码：
         * final void checkForComodification() {
         *             if (modCount != expectedModCount)
         *                 throw new ConcurrentModificationException();
         *         }
         */
        for (String str : list) {
            if (str.equals("Hooo")) {
                list.remove(str);
                // 当然，如果想要使用foreach增强，那就在执行remove方法后，直接break跳出循环，这里需要根据业务来，如果list中只有一个想要删除的元素那就可以使用break
                break;
            }

        }
        System.out.println(list);
    }

    /**
     * 正确操作
     *
     * @param i
     */
    private static void removeStr(Integer i) {
        List<String> list = new ArrayList<String>() {{
            add("Hooo");
            add("Hqqq");
            add("Hxxxx");
            add("H");
        }};
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            if (next.equals("Hooo")) {
                iterator.remove();
                break;
            }
        }
        System.out.println(list);
    }

    /**
     * jdk8新特性
     */
    private static void removeStrEnity() {
        List<String> list = new ArrayList<String>() {{
            add("Hooo");
            add("Hqqq");
            add("Hxxxx");
            add("H");
        }};
        List<String> hooo = list.stream().filter(str -> !str.equals("Hooo")).collect(Collectors.toList());
        System.out.println(hooo);
    }

    private static void removeConcurrentLinkedDeque() {
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};
        for (String str : deque) {
            if (str.equals("Hollis")) {
                deque.remove(str);
            }
        }
        System.out.println(deque);
    }

    public static void main(String[] args) {
        // removeStr();
        // removeStr(1);
        // removeStrEnity();
        // removeConcurrentLinkedDeque();

        System.out.println(20103%5);
    }


}
