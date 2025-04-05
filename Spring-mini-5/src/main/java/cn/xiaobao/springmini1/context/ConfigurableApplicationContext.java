package cn.xiaobao.springmini1.context;

public interface ConfigurableApplicationContext extends ApplicationContext
{

    void refresh() throws Exception;
}
