package com.wuyang.springinitializerwebthymeleaf.config;

import com.wuyang.springinitializerwebthymeleaf.component.YamlHttpMessagerConverter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyBeanConfig {
  @Bean
  public WebMvcConfigurer webMvcConfigurer() {
    return new WebMvcConfigurer() {
      @Override//配置静态资源
      public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //这里配置以这里优先。这里没有配置以配置application.properties或者application.yaml文件优先
        registry.addResourceHandler("/prefix/**")//前缀，不是实际文件路径，是网页请求路径
            .addResourceLocations("classpath:/static/","classpath:/a/","classpath:/b/","classpath:/resources/" ,"classpath:/META-INF/resources/")//默认寻找第一个设置的路径，代码所示static
            //默认访问文件路径,必须以斜扛结尾
            .setCacheControl(CacheControl.maxAge(1180,TimeUnit.SECONDS));
      }

      @Override//配置拦截器
      public void addInterceptors(InterceptorRegistry registry) {

      }

      @Override
      public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(new YamlHttpMessagerConverter());
      }

//      @Override
//      public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new MyYamlHttpMessagerConverter());
//      }
    };
  }
}
