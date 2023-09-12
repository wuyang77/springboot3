package com.wuyang.springbootfeatures.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher implements ApplicationEventPublisherAware {

  ApplicationEventPublisher applicationEventPublisher;

  /**
   * 1.底层发送事件用的组件，SpringBoot会通过ApplicationEventPublisherAware接口自动注入给我们
   * 2.事件是广播出去的。所有监听这个事件的监听器都可以收到
   * @param applicationEventPublisher event publisher to be used by this object
   */
  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  //所以事件都可以发
  public void sendEvent(ApplicationEvent event) {
    //调用底层API发送事件
    applicationEventPublisher.publishEvent(event);
  }
}
