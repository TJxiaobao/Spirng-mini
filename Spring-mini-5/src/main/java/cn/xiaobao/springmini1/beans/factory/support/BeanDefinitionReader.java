package cn.xiaobao.springmini1.beans.factory.support;

import cn.xiaobao.springmini1.core.io.Resource;
import cn.xiaobao.springmini1.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws Exception;

    void loadBeanDefinitions(Resource... resources) throws Exception;

    void loadBeanDefinition(String location) throws Exception;


}
