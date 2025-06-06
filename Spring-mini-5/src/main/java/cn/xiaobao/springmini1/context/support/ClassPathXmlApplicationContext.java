package cn.xiaobao.springmini1.context.support;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.BeansException;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return this.configLocations;
    }

    /**
     * 处理配置路径
     * @param location 原始配置路径
     * @return 处理后的配置路径
     */
    protected String resolvePath(String location) {
        if (StrUtil.isEmpty(location)) {
            return location;
        }
        // 如果路径以classpath:开头，去掉这个前缀
        if (location.startsWith("classpath:")) {
            return location.substring("classpath:".length());
        }
        return location;
    }
}