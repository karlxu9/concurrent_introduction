package str;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/26 10:28
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class A {

    public void fo_function() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println("A");
    }

}

class B extends A {

    @Override
    public void fo_function() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println("B");
    }
}

class C extends B {

    @Override
    public void fo_function() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> aClass = Class.forName("str.A");
        Method fo_function = aClass.getMethod("fo_function");
        Object o = aClass.newInstance();
        fo_function.invoke(o);
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        new C().fo_function();

    }
}