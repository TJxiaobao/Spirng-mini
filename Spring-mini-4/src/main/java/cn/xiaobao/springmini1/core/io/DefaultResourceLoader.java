package cn.xiaobao.springmini1.core.io;

import org.springframework.util.Assert;

import java.net.URL;


public class DefaultResourceLoader implements ResourceLoader{



    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (Exception e) {
                return new FileSystemResource(location);
            }
        }
    }
}
