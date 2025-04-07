package cn.xiaobao.springmini1.context.support;

import cn.xiaobao.springmini1.beans.factory.ConfigurableListableBeanFactory;
import cn.xiaobao.springmini1.beans.factory.factory.BeanFactoryPostProcessor;
import cn.xiaobao.springmini1.beans.factory.factory.BeanPostProcessor;
import cn.xiaobao.springmini1.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.BeansException;

import java.util.Map;

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void refresh() throws BeansException {
        // 1. 创建BeanFactory
        refreshBeanFactory();
        
        // 2. 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        
        // 3. 在实例化bean之前，执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);
        
        // 4. 注册BeanPostProcessor
        registerBeanPostProcessors(beanFactory);
        
        // 5. 初始化单例bean
        beanFactory.preInstantiateSingletons();
    }

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
        return beanFactory;
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }
}
