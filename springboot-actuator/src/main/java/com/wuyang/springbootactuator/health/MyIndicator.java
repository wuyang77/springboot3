package com.wuyang.springbootactuator.health;

import com.wuyang.springbootactuator.component.MyHealthComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

/**
 * 1.实现HealthIndicator 接口来定制组件的健康状态对象（Health）返回
 */
@Component
public class MyIndicator extends AbstractHealthIndicator {
  @Autowired
  MyHealthComponent myComponent;

  @Override
  protected void doHealthCheck(Builder builder) throws Exception {
    //自定义检查方法
    int check = myComponent.check();
    if (check == 1) {
      //存活
      builder.up().withDetail("code","1000")
                  .withDetail("msg","活的很健康")
                  .withDetail("data","我的名字叫haha")
                  .build();
    }else {
      //下线
      builder.down().withDetail("code","1001")
                    .withDetail("msg","死的很健康")
                    .withDetail("data","我的名字叫haha")
                    .build();
    }
  }
}
