package cn.xiaobao.springmini1.beans.factory.factory;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
