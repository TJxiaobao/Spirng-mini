package cn.xiaobao.springmini1.beans.factory;

import cn.xiaobao.springmini1.beans.factory.factory.AutowireCapableBeanFactory;
import cn.xiaobao.springmini1.beans.factory.factory.BeanDefinition;
import cn.xiaobao.springmini1.beans.factory.factory.ConfigurableBeanFactory;
import org.springframework.beans.BeansException;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory  {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
