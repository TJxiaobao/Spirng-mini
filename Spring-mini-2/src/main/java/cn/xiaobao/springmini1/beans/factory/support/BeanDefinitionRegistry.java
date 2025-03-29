package cn.xiaobao.springmini1.beans.factory.support;

import cn.xiaobao.springmini1.beans.factory.factory.BeanDefinition;
import org.springframework.beans.BeansException;

public interface BeanDefinitionRegistry {

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    public BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
