package jvm;

import lombok.SneakyThrows;

import java.io.InputStream;

/**
 * @author initial.y
 * @className ClassLoaderTest
 * @description
 * @date 2021/9/12
 */
public class ClassLoaderTest {

    @SneakyThrows
    public static void main(String[] args) {
        // AppClassLoader 应用类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader: " + systemClassLoader);
        // AppClassLoader 应用类加载器
        ClassLoader classLoaderTestLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("classLoaderTestLoader:" + classLoaderTestLoader);
        // ExtClassLoader 扩展类加载器
        ClassLoader parentClassLoader = classLoaderTestLoader.getParent();
        System.out.println("parentClassLoader: " + parentClassLoader);
        // null
        ClassLoader parentParent = parentClassLoader.getParent();
        System.out.println("parentParentClassLoader:" + parentParent);


        ClassLoader myClassLoader = new ClassLoader() {
            @SneakyThrows
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                // 自定义类加载器
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }
                byte[] bytes = new byte[is.available()];
                is.read(bytes);
                return defineClass(name, bytes, 0, bytes.length);
            }


        };
        // 测试不同类加载器实例化对象是否一致: 不一致
        Object myClassLoaderTest = myClassLoader.loadClass("jvm.ClassLoaderTest");
        System.out.println(myClassLoaderTest);
        System.out.println(myClassLoaderTest instanceof ClassLoaderTest);

    }



}
