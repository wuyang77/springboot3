package com.wuyang.springbootactuator.component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class MyHealthComponent {
  Counter counter =null;

  /**
   * 注入MeterRegistry来保存和统计所有指标
   * @param meterRegistry
   */

  public MyHealthComponent(MeterRegistry meterRegistry) {
    counter = meterRegistry.counter("myhaha.hello");
  }
  public int check() {
    //业务代码判断这个组件收否该是存活状态
    return 2;
  }
  public void hello() {
    System.out.println("hello");
    counter.increment();
  }
}
