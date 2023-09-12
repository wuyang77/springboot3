package com.wuyang.springbootfeatures.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyListener implements ApplicationListener<ApplicationEvent> {

  @Override
  public void onApplicationEvent(ApplicationEvent event) {
    System.out.println("感知到事件到达====="+event.getClass().getSimpleName());
  }
}
