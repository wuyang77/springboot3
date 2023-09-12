package com.wuyang.springkafkamessage;

import com.wuyang.springkafkamessage.entity.Person;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StopWatch;

@SpringBootTest
class SpringKafkaMessageApplicationTests {

  @Autowired
  KafkaTemplate kafkaTemplate;
  @Test
  void contextLoads() {
    StopWatch stopWatch = new StopWatch();
    CompletableFuture[] futures = new CompletableFuture[10000];
    stopWatch.start();
    for (int i = 0; i < 10000; i++) {
      //JUC
      CompletableFuture future = kafkaTemplate.send("things1","hahahahaha"+i, "哈哈哈哈哈啊"+i);
      futures[i] = future;
    }
    CompletableFuture.allOf(futures).join();
    stopWatch.stop();
    long totalTimeMillis = stopWatch.getTotalTimeMillis();
    System.out.println("10000条消息发送完成：ms时间："+totalTimeMillis);
  }
  @Test
  void send() {
    //发送Json对象
    CompletableFuture f = kafkaTemplate.send("newshaha", "person",
        new Person(1L, "wuyang", "2388958622@qq.com"));

    f.join();
    System.out.println("消息发送成功。。。");
  }

}
