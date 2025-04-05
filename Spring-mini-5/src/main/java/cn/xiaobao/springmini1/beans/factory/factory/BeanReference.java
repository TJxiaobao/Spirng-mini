package cn.xiaobao.springmini1.beans.factory.factory;

public class BeanReference {

    private final String BeanName;

    public BeanReference(String BeanName) {
        this.BeanName = BeanName;
    }

    public String getBeanName() {
        return BeanName;
    }

}
