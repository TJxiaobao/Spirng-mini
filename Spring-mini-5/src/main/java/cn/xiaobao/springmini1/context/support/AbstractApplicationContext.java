package cn.xiaobao.springmini1.context.support;

import cn.xiaobao.springmini1.beans.factory.ConfigurableListableBeanFactory;
import cn.xiaobao.springmini1.beans.factory.factory.BeanFactoryPostProcessor;
import cn.xiaobao.springmini1.beans.factory.factory.BeanPostProcessor;
import cn.xiaobao.springmini1.beans.factory.factory.ConfigurableBeanFactory;
import cn.xiaobao.springmini1.context.ConfigurableApplicationContext;
import cn.xiaobao.springmini1.core.io.DefaultResourceLoader;
import org.springframework.beans.BeansException;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1. 创建BeanFactory

        // 2. 加载BeanDefinition
        // 3. 注册单例Bean
        // 4. 发布事件
        // 5. 完成后处理器的注册
        // 6. 初始化单例Bean
        // 7. 发布事件
    }

    protected abstract void refreshBeanFactory() throws Exception;

    protected abstract ConfigurableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (Map.Entry<String, BeanPostProcessor> entry : beansOfType.entrySet()) {
            beanFactory.addBeanPostProcessor(entry.getValue());
        }
    }


}
