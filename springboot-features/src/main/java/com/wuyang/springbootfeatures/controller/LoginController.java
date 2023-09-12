package com.wuyang.springbootfeatures.controller;

import com.wuyang.springbootfeatures.entity.UserEntity;
import com.wuyang.springbootfeatures.event.EventPublisher;
import com.wuyang.springbootfeatures.event.LoginHandleEvent;
import com.wuyang.springbootfeatures.service.AccountService;
import com.wuyang.springbootfeatures.service.CouponService;
import com.wuyang.springbootfeatures.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  @Autowired
  AccountService accountService;
  @Autowired
  CouponService couponService;
  @Autowired
  SysService sysService;
  @Autowired
  EventPublisher eventPublisher;

  @GetMapping("/login")
  public String login(@RequestParam("username") String username, @RequestParam("password") String password ) {

    //业务处理
    System.out.println("模拟业务处理登陆完成。。。。");
    //TODO 发送事件
    LoginHandleEvent event = new LoginHandleEvent(new UserEntity(username, password));//创建事件信息
    eventPublisher.sendEvent(event);
    System.out.println("================================");
    accountService.addServiceScore(username);
    couponService.sendCoupon(username);
    sysService.recordLog(username);

    //设计模式：对新增开放，对修改关闭
    //xxxxxxxxxxx
    //xxxxxxxxxxx
    //xxxxxxxxxxx

    return "用户："+username+"登录成功";
  }

}
