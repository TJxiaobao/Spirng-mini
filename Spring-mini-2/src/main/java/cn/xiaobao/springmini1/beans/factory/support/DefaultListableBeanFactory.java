package cn.xiaobao.springmini1.beans.factory.support;

import cn.xiaobao.springmini1.beans.factory.factory.BeanDefinition;
import cn.xiaobao.springmini1.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.BeansException;

import java.util.HashMap;
import java.util.Map;


public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new RuntimeException("No bean named " + beanName + " is defined");
        }
        return beanDefinition;
    }
}
