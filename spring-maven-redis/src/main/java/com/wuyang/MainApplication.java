package com.wuyang;

import com.wuyang.bean.Cat;
import com.wuyang.bean.Dog;
import com.wuyang.bean.Pig;
import com.wuyang.bean.Sheep;
import com.wuyang.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
  public static void main(String[] args) {
    var ioc = SpringApplication.run(MainApplication.class);
//    for (String name : ioc.getBeanDefinitionNames()) {
//      System.out.println(name);
//    }

//    for (String s : ioc.getBeanNamesForType(FastsqlException.class)) {
//      System.out.println(s);
//    }
    for (String s : ioc.getBeanNamesForType(Cat.class)) {
      System.out.println(s);
    }
    for (String s : ioc.getBeanNamesForType(Dog.class)) {
      System.out.println(s);
    }
    for (String s : ioc.getBeanNamesForType(User.class)) {
      System.out.println(s);
    }

    Object userhaha1 = ioc.getBean("userhaha");
    Object userhaha2 = ioc.getBean("userhaha");
    System.out.println(userhaha1 == userhaha2);//验证默认他是单实例，通过scope调整为多实例

    System.out.println(ioc.getBean(Pig.class));
    System.out.println(ioc.getBean(Sheep.class));
  }
}
