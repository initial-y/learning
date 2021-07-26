package spring.ioc.dao.impl;

import spring.ioc.dao.IocDao;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class IocDaoOneImpl implements IocDao {
    @Override
    public List<String> query() {
        return Arrays.asList("ioc one");
    }
}
