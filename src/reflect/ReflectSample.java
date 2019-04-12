package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/3/30 15:56
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class ReflectSample {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        Class clazz = Class.forName("reflect.Robot");
        Robot robot = (Robot) clazz.newInstance();
        System.out.println("Class name is " + clazz.getName());
        Method throwHello = clazz.getDeclaredMethod("throwHello", String.class);
        throwHello.setAccessible(true);
        throwHello.invoke(robot, " Bob ");
        Method sayHi = clazz.getMethod("sayHi", String.class);
        sayHi.setAccessible(true);
        Object welcome = sayHi.invoke(robot, " welcome");
        System.out.println("beijing " + welcome);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot,"bbbb");
        throwHello.invoke(robot, " Bob ");

    }

}
