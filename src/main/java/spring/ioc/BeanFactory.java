package spring.ioc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author initial.y
 * @className test
 * @description
 * @date 2021/7/22
 */
public class BeanFactory {

    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("properties initial fail, msg: " + e.getMessage());
        }
    }

    public static Object getBean(String name) {
        try {
            return Class.forName(properties.getProperty(name)).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }


    private static Map<String, Object> beanMap = new HashMap<>();

    public static Object getSingletonBean(String name) {
        // double check
        if (!beanMap.containsKey(name)) {
            synchronized (BeanFactory.class) {
                // 内部判断加的是Class对象的锁,getSingletonBean()方法是通过类名.的方式来访问
                if (!beanMap.containsKey(name)) {
                    try {
                        Object obj = Class.forName(properties.getProperty(name)).newInstance();
                        beanMap.put(name, obj);
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e.getMessage());
                    }
                }
            }
        }
        return beanMap.get(name);
    }


}
