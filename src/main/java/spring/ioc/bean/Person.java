package spring.ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import spring.ioc.anno.IocAnno;

@Data
@IocAnno
public class Person {

    @Value("test")
    private String name;

    @Value("1")
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
