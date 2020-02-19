package base.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionDemoTest
 * @Descripiton
 * @Author initial_yang
 * @Date 2020/2/19
 */
public class ReflectionDemoTest {

    /**
     * 在未运行前就已经知道了要运行的类
     */
    @Test
    public void test_new_object() {
        ReflectionDemo demo = new ReflectionDemo();
        demo.printParam();
    }

    /**
     * 整个程序运行的时候，从字符串base.reflection.ReflectionDemo，才知道要操作的类
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    @Test
    public void test_reflection() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
//        Class clz = Class.forName("base.reflection.ReflectionDemo");

//        Class clz = ReflectionDemo.class;

        ReflectionDemo demo = new ReflectionDemo();
        Class clz = demo.getClass();

        Method method = clz.getMethod("printParam");
//        Constructor constructor = clz.getConstructor();
//        Object object = constructor.newInstance();
        Object object = clz.newInstance();
        method.invoke(object);
    }

    @Test
    public void test_reflection_create_object() throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clz = Class.forName("base.reflection.ReflectionDemo");
        ReflectionDemo demo = (ReflectionDemo) clz.newInstance();
        demo.printParam();

        Constructor constructor = clz.getConstructor();
        ReflectionDemo demo1 = (ReflectionDemo) constructor.newInstance();
    }

    @Test
    public void test_reflection_get_constructor() throws ClassNotFoundException, NoSuchMethodException {
        Class clz = Class.forName("base.reflection.ReflectionDemo");
        Constructor[] constructors = clz.getConstructors();
        System.out.println(constructors.length);

        Constructor[] declaredConstructors = clz.getDeclaredConstructors();
        System.out.println(declaredConstructors.length);

        Constructor paramConstructor = clz.getConstructor(Integer.class);
        System.out.println(paramConstructor);

        Constructor declaredParamConstructor = clz.getDeclaredConstructor(Integer.class);
        System.out.println(declaredParamConstructor);
    }

    @Test
    public void test_reflection_get_methods() throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException {
        Class clz = Class.forName("base.reflection.ReflectionDemo");
        Method[] pubMethods = clz.getMethods();
        System.out.println(pubMethods.length);

        Method[] clzMethods = clz.getDeclaredMethods();
        System.out.println(clzMethods.length);

        Method declaredMethod = clz.getDeclaredMethod("print", int.class);
        declaredMethod.invoke(clz.newInstance(), 1);
    }

    @Test
    public void test_reflection_get_fields() throws ClassNotFoundException, NoSuchFieldException {
        Class clz = Class.forName("base.reflection.ReflectionDemo");
        Field[] pubFields = clz.getFields();
        System.out.println(pubFields.length);

        Field[] fields = clz.getDeclaredFields();
        System.out.println(fields.length);

        Field pubField = clz.getField("num");
        System.out.println(pubField);

        Field declaredField = clz.getDeclaredField("param");
        System.out.println(declaredField);
    }

    @Test
    public void test_reflection_print_invoke_method() throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException {
        Class clz = Class.forName("base.reflection.ReflectionDemo");
        Method declaredMethod = clz.getDeclaredMethod("printNum", int.class);
        declaredMethod.invoke(clz.newInstance(), 111);
    }

    @Test
    public void test_reflection_modify_access_permission() throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clz = Class.forName("base.reflection.ReflectionDemo");
        Constructor constructor = clz.getDeclaredConstructor(Integer.class);
        constructor.setAccessible(true);
        constructor.newInstance(111);
    }
}
