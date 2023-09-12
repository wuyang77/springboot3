package com.wuyang.springbootfeatures.service;

import com.wuyang.springbootfeatures.event.LoginHandleEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class HaHaService {
  @EventListener
  public void onEvent(LoginHandleEvent event) {
    System.out.println("HaHaService 感知到事件"+event.getClass().getSimpleName());
    //调用业务

  }}
