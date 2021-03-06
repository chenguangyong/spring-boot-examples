package com.chen.springbootdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: chen
 * @Date: 2018/12/11 17:10
 * @Description:swagger2配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2Config extends WebMvcConfigurationSupport {
    /**
     * 日志管理
     */
    private Logger log = LoggerFactory.getLogger(Swagger2Config.class);

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .pathMapping("/api/v1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chen.springbootdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder().title("SpringBoot中使用Swagger2构建RESTful APIs")
                .description("请看博客:https://blog.csdn.net/qq_38685242")
                .contact(new Contact("cgy", "https://blog.csdn.net/qq_38685242", "1192165267@qq.com"))
                .version("1.0")
                .build();
    }
    /**
     * 防止@EnableMvc把默认的静态资源路径覆盖了，手动设置的方式
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
    }



}
