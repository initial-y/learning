package spring.ioc.service.impl;

import org.junit.jupiter.api.Test;
import spring.ioc.service.IocService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author initial.y
 * @className
 * @description
 * @date 2021/7/22
 */
class IocServiceImplTest {

    IocService iocService = new IocServiceImpl();

    @Test
    void query() {
        System.out.println(iocService.query());
    }
}