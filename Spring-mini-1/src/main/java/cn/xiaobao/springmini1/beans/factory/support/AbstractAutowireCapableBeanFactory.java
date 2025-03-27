package cn.xiaobao.springmini1.beans.factory.support;

import cn.xiaobao.springmini1.beans.factory.factory.BeanDefinition;

public class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected BeanDefinition getBeanDefinition(String name) {
        return null;
    }

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        addSingleton(name, bean);
        return bean;
    }
}
