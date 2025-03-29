package cn.xiaobao.springmini1.beans.factory.support;


import cn.xiaobao.springmini1.beans.factory.BeanFactory;
import cn.xiaobao.springmini1.beans.factory.factory.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String name);

    protected abstract Object createBean(String name, BeanDefinition beanDefinition);
}
