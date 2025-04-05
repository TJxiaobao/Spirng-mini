package cn.xiaobao.springmini1.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource{

    private String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassPathResource.class.getClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(path);
        if (resourceAsStream == null) {
            throw new IOException(path + " cannot be opened because it does not exist");
        }
        return resourceAsStream;
    }
}
