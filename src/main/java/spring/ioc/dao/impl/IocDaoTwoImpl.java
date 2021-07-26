package spring.ioc.dao.impl;

import spring.ioc.dao.IocDao;

import java.util.Arrays;
import java.util.List;

public class IocDaoTwoImpl implements IocDao {
    @Override
    public List<String> query() {
        return Arrays.asList("ioc two");
    }
}
