package com.wuyang.springbootfeatures.listener;

import java.time.Duration;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MyAppListener implements SpringApplicationRunListener {

  @Override
  public void starting(ConfigurableBootstrapContext bootstrapContext) {
    System.out.println("启动");
  }

  @Override
  public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext,
      ConfigurableEnvironment environment) {
    System.out.println("环境准备完成");
  }

  @Override
  public void contextPrepared(ConfigurableApplicationContext context) {
    System.out.println("ioc容器准备完成");
  }

  @Override
  public void contextLoaded(ConfigurableApplicationContext context) {
    System.out.println("ioc容器加载完成");
  }

  @Override
  public void started(ConfigurableApplicationContext context, Duration timeTaken) {
    System.out.println("已启动");
  }

  @Override
  public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
    System.out.println("已经就绪");
  }

  @Override
  public void failed(ConfigurableApplicationContext context, Throwable exception) {
    SpringApplicationRunListener.super.failed(context, exception);
  }
}
