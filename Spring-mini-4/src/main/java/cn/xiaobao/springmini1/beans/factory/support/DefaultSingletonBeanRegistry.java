package cn.xiaobao.springmini1.beans.factory.support;

import cn.xiaobao.springmini1.beans.factory.factory.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return map.get(beanName);
    }

    protected void addSingleton(String beanName, Object bean) {
        map.put(beanName, bean);
    }
}
