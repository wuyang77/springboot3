package com.wuyang.config;


import com.wuyang.bean.Pig;
import com.wuyang.bean.Sheep;
import com.wuyang.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;


//@Configuration//配置类，替代以前的配置类
//@Import(FastsqlException.class)//导入外部jar的类到容器中，注册到组件
@SpringBootConfiguration
@EnableConfigurationProperties(Sheep.class)//导入第三方写好的组件进行属性绑定
public class AppConfig {
  @Scope("prototype")
  @Bean("userhaha")//替代以前的Bean标签
  public User user01() {
    User user = new User();
    user.setId(1L);
    user.setName("吴洋");
    return user;
  }


  @ConfigurationProperties(prefix = "pig")
  @Bean
  public Pig pig() {
    return new Pig();
  }


}
