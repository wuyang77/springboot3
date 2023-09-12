package com.wuyang.springbootredis;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

@SpringBootTest
class SpringbootRedisApplicationTests {
  @Autowired
  StringRedisTemplate stringRedisTemplate;


  @Test
  void contextLoads() {
    stringRedisTemplate.opsForValue().set("haha", UUID.randomUUID().toString());
    String haha = stringRedisTemplate.opsForValue().get("haha");
    System.out.println(haha);
  }

  @Test
  void testList() {
    String listName = "listtest";
    stringRedisTemplate.opsForList().leftPush(listName,"1");
    stringRedisTemplate.opsForList().leftPush(listName,"2");
    stringRedisTemplate.opsForList().leftPush(listName,"3");
    String s = stringRedisTemplate.opsForList().leftPop(listName);
    Assertions.assertEquals("3",s);
  }
  @Test
  void testSet() {
    String setName = "settest";
    stringRedisTemplate.opsForSet().add(setName,"1","2","3","4");
    Boolean member1 = stringRedisTemplate.opsForSet().isMember(setName, "2");
    Assertions.assertTrue(member1);
    Boolean member2 = stringRedisTemplate.opsForSet().isMember(setName, "5");
    Assertions.assertFalse(member2);
  }
  @Test
  void testZset() {
    String zsetName = "zsetTest";
    stringRedisTemplate.opsForZSet().add(zsetName,"小狐狸",90.00);
    stringRedisTemplate.opsForZSet().add(zsetName,"小猫咪",99.00);
    stringRedisTemplate.opsForZSet().add(zsetName,"小羊肖恩",9.00);
    stringRedisTemplate.opsForZSet().add(zsetName,"小鼠杰瑞",97.10);

    TypedTuple<String> poppedMax = stringRedisTemplate.opsForZSet().popMax(zsetName);
    String value = poppedMax.getValue().toString();
    Double score = poppedMax.getScore();
    System.out.println(value+"==="+score);

  }

  @Test
  void testHash() {
    String mapName = "amap";
    stringRedisTemplate.opsForHash().put(mapName,"name","小猫咪");
    stringRedisTemplate.opsForHash().put(mapName,"age","5");

    String name = (String) stringRedisTemplate.opsForHash().get(mapName, "name");
    String age = (String) stringRedisTemplate.opsForHash().get(mapName, "age");
    System.out.println(name+"有"+age+"岁了！");
  }
}
