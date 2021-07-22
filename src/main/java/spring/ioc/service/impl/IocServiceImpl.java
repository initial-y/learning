package spring.ioc.service.impl;

import spring.ioc.BeanFactory;
import spring.ioc.dao.IocDao;
import spring.ioc.service.IocService;

import java.util.List;

/**
 * @author initial.y
 * @className
 * @description
 * @date 2021/7/22
 */
public class IocServiceImpl implements IocService {

    private IocDao iocDao = (IocDao) BeanFactory.getBean("iocDao");

    @Override
    public List<String> query() {
        return iocDao.query();
    }
}
