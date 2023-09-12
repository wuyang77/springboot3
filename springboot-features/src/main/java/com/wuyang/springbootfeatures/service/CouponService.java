package com.wuyang.springbootfeatures.service;

import com.wuyang.springbootfeatures.entity.UserEntity;
import com.wuyang.springbootfeatures.event.LoginHandleEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
  public void sendCoupon(String username) {
    System.out.println(username+"得到了一张优惠卷");
  }

  @Async
  @Order(1)
  @EventListener
  public void onEvent(LoginHandleEvent event) {
    System.out.println("CouponService 感知到事件"+event.getClass().getSimpleName());
    UserEntity source = (UserEntity) event.getSource();
    sendCoupon(source.getUsername());
  }
}
