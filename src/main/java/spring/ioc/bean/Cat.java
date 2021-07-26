package spring.ioc.bean;

import lombok.Data;
import spring.ioc.anno.IocAnno;

@Data
@IocAnno
public class Cat {

    private String name;

    private Person master;

    public void init() {
        System.out.println("cat init");
    }

    public void destroy() {
        System.out.println("cat destroy");
    }

}
