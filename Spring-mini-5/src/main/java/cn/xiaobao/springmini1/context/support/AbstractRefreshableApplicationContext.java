package cn.xiaobao.springmini1.context.support;

import cn.xiaobao.springmini1.beans.factory.ConfigurableListableBeanFactory;
import cn.xiaobao.springmini1.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.BeansException;

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory1 = createBeanFactory();
        loadBeanDefinitions(beanFactory1);
        this.beanFactory = beanFactory1;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;


    @Override
    public ConfigurableListableBeanFactory getBeanFactory() {
        // todo 不知道为什么需要类型转换
        return (ConfigurableListableBeanFactory) beanFactory;
    }

}
