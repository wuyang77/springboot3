package com.wuyang.springbootfeatures.service;

import com.wuyang.springbootfeatures.entity.UserEntity;
import com.wuyang.springbootfeatures.event.LoginHandleEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(2)
@Service
public class AccountService implements ApplicationListener<LoginHandleEvent> {
  public void addServiceScore(String username) {
    System.out.println(username+"加了一分");
  }

  @Override
  public void onApplicationEvent(LoginHandleEvent event) {
    System.out.println("AccountService 感知到事件"+event.getClass().getSimpleName());
    UserEntity source = (UserEntity) event.getSource();
    addServiceScore(source.getUsername());
  }
}
