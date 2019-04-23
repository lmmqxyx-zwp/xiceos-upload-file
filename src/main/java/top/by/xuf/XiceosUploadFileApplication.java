package top.by.xuf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@Configuration
public class XiceosUploadFileApplication {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(XiceosUploadFileApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大
        factory.setMaxFileSize(environment.getProperty("multipart.maxFileSize"));
        // 设置总上传的文件的大小
        factory.setMaxRequestSize(environment.getProperty("multipart.maxRequestSize"));

        return factory.createMultipartConfig();
    }

}
