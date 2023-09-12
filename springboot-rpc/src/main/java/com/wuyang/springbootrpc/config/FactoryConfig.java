package com.wuyang.springbootrpc.config;

import com.wuyang.springbootrpc.service.ExpressInterface;
import com.wuyang.springbootrpc.service.WeatherInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class FactoryConfig {

  @Bean
  HttpServiceProxyFactory factory(@Value("${aliyun.appcode}") String appcode) {
    //1、创建客户端
    WebClient client = WebClient.builder()
        .defaultHeader("Authorization", "APPCODE "+appcode)
        .codecs(clientCodecConfigurer -> {
          clientCodecConfigurer
              .defaultCodecs()
              .maxInMemorySize(256*1024*1024);
          //响应数据量太大有可能会超出BufferSize，所以这里设置的大一点
        })
        .build();
    //2、创建工厂
    HttpServiceProxyFactory factory = HttpServiceProxyFactory
        .builder(WebClientAdapter.forClient(client)).build();
    return factory;
  }

  @Bean
  WeatherInterface weatherInterface(HttpServiceProxyFactory factory) {
    //3、获取代理对象
    WeatherInterface weatherInterface = factory.createClient(WeatherInterface.class);
    return weatherInterface;
  }

  @Bean
  ExpressInterface smsInterface(HttpServiceProxyFactory factory) {
    ExpressInterface smsInterface = factory.createClient(ExpressInterface.class);
    return smsInterface;
  }

}
