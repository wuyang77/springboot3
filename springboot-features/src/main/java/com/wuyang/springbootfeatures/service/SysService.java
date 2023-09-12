package com.wuyang.springbootfeatures.service;

import com.wuyang.springbootfeatures.entity.UserEntity;
import com.wuyang.springbootfeatures.event.LoginHandleEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SysService {
  public void recordLog(String username) {
    System.out.println(username+"登录信息已被记录");
  }

  @EventListener
  public void haha(LoginHandleEvent event) {
    System.out.println("SysService 感知到事件"+event.getClass().getSimpleName());
    UserEntity source = (UserEntity) event.getSource();
    recordLog(source.getUsername());
  }
}
