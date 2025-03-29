package cn.xiaobao.springmini1;

import cn.xiaobao.springmini1.beans.factory.factory.BeanDefinition;
import cn.xiaobao.springmini1.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringMini1ApplicationTests {

    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "xiaobao");
        userService.queryUserInfo();
    }

}
