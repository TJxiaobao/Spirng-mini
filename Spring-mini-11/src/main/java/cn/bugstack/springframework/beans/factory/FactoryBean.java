package cn.bugstack.springframework.beans.factory;

public interface FactoryBean<T> {

    T getOject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();

}
