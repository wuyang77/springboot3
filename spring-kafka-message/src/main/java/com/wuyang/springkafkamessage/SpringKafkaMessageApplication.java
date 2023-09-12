package com.wuyang.springkafkamessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * KafkaAutoConfiguration提供以下功能
 * 1.KafkaProperties
 *  - bootstrapServers:Kafka集群所有服务器的地址
 *  - properties：参数设置
 *  - consumer：消费者
 *  - producer：生产者
 * 2.@EnableKafka：开启Kafka注解驱动
 * 3.KafkaTemplate:收发消息
 * 4.KafkaAdmin：维护主题
 * 5.@EnableKafka + @KafkaListener
 *  - 1.消费者来接收数据，需要有group-id
 *  - 2.收消息使用@KafkaListener + ComsumerRecord record或者String Data
 *  - 3.spring.kafka 开始的所有配置
 * 6.核心概念
 *  - 分区：分散存储，1T的数据分散到n个节点
 *  - 副本：备份机制，每个小分区都是有备份的
 *  - 主题；topics 消息是发送给主题的
 *  - 步骤
 *    - 获取leader分区，给leader发送消息
 *    - 同一个消费者里面的消费者是队列竞争关系
 *    - 不同消费者组里面的消费者是发布/订阅模式
 */
@EnableKafka
@SpringBootApplication
public class SpringKafkaMessageApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringKafkaMessageApplication.class, args);
  }

}
