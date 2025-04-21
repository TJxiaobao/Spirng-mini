package cn.bugstack.springframework.beans.factory;

public interface DisposableBean {

    /**
     * 销毁方法
     */
    void destroy() throws Exception;
}
