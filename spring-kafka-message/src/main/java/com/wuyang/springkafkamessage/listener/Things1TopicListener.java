package com.wuyang.springkafkamessage.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * 同一组是竞争关系，不同组是发布订阅
 */
@Component
public class Things1TopicListener {
  //默认的监听是从消息队列最后一个消息开始拿。新消息才能拿到
  @KafkaListener(topics = "things1",groupId = "haha")
  public void haha(ConsumerRecord record) {
    //1.获取消息的各种详细信息
    String topic = record.topic();
    Object key = record.key();
    Object value = record.value();
    System.out.println("主题是【"+topic+"】 收到消息的:key【"+key+"】 value【"+value+"】");
  }
  //拿到以前完成的消息
  @KafkaListener(groupId = "hehe",topicPartitions = {
      @TopicPartition(topic = "things1",partitionOffsets = {
          @PartitionOffset(partition = "0",initialOffset = "0")
      })
  })
  public void hehe(ConsumerRecord record) {
    //1.获取消息的各种详细信息
    String topic = record.topic();
    Object key = record.key();
    Object value = record.value();
    System.out.println("=============主题是【"+topic+"】 收到消息的:key【"+key+"】 value【"+value+"】");
  }
}
