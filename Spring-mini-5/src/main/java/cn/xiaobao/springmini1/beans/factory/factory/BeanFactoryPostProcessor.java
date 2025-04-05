package cn.xiaobao.springmini1.beans.factory.factory;

import cn.xiaobao.springmini1.beans.factory.ConfigurableListableBeanFactory;
import org.springframework.beans.BeansException;

public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
