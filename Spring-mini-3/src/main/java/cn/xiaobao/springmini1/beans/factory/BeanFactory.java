package cn.xiaobao.springmini1.beans.factory;

import cn.xiaobao.springmini1.beans.factory.factory.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public interface BeanFactory {


    public Object getBean(String name);

    public Object getBean(String name, Object... args);
}
