package cn.xiaobao.springmini1.beans.factory.factory;

public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;


    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;

}
