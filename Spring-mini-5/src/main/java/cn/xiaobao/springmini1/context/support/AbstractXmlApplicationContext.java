package cn.xiaobao.springmini1.context.support;

import cn.xiaobao.springmini1.beans.factory.support.DefaultListableBeanFactory;
import cn.xiaobao.springmini1.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.BeansException;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            for (String configLocation : configLocations) {
                beanDefinitionReader.loadBeanDefinition(configLocation);
            }
        }
    }

    protected abstract String[] getConfigLocations();
}
