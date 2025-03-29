package cn.xiaobao.springmini1.beans.factory.support;

import cn.xiaobao.springmini1.beans.factory.factory.BeanDefinition;

import java.lang.reflect.Constructor;

public class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{


    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

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

    @Override
    public Object getBean(String name, Object... args) {
        return null;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
    }
}
