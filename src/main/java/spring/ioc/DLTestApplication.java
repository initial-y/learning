package spring.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.anno.IocAnno;
import spring.ioc.bean.Dog;
import spring.ioc.bean.Person;
import spring.ioc.config.IocConfig;
import spring.ioc.dao.IocDao;

import java.util.Map;
import java.util.stream.Stream;

public class DLTestApplication {
    public static void main(String[] args) {
//        BeanFactory factory = new ClassPathXmlApplicationContext("dl/dl-byname.xml");
//        // 参数传入id
//        Person person = (Person) factory.getBean("person");
//        System.out.println(person);

//        BeanFactory factory = new ClassPathXmlApplicationContext("dl/dl-bytype.xml");
//        // 参数传类型
//        Person person = factory.getBean(Person.class);
//        System.out.println(person);
//
//        IocDao iocDao = factory.getBean(IocDao.class);
//        System.out.println(iocDao.query());


        // 批量获取bean
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("dl/dl-bytype.xml");
//        Map<String, IocDao> beans = ctx.getBeansOfType(IocDao.class);
//        beans.forEach((beanName, bean) -> {
//            System.out.println(beanName + " : " + bean.toString());
//        });

        // 根据注解获取bean
//        Map<String, Object> annoBeans = ctx.getBeansWithAnnotation(IocAnno.class);
//        annoBeans.forEach((beanName, bean) -> {
//            System.out.println(beanName + " : " + bean.toString());
//        });

        // 获取IOC容器中所有的bean
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        // 利用jdk8的Stream快速编写打印方法
//        Stream.of(beanNames).forEach(System.out::println);

        // 延迟查找
//        ObjectProvider<Person> provider = ctx.getBeanProvider(Person.class);
//        Person person = provider.getIfAvailable(Person::new);
//        System.out.println(person);

        // 配置类启动
        ApplicationContext ctx = new AnnotationConfigApplicationContext(IocConfig.class);
        Dog dog = ctx.getBean(Dog.class);
        System.out.println(dog);

    }
}
