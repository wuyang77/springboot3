package com.wuyang.springbootfeatures.event;

import com.wuyang.springbootfeatures.entity.UserEntity;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class LoginHandleEvent extends ApplicationEvent {
  //source代表是谁登录成功了
  public LoginHandleEvent(UserEntity source) {
    super(source);
  }
}
