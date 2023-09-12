package com.wuyang.springinitializerwebthymeleaf.biz;

import com.wuyang.springinitializerwebthymeleaf.bean.Person;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * 专门处理user有关的业务
 */

@Slf4j
@Component
public class UserBizHandler {
  public ServerResponse getUser(ServerRequest serverRequest) throws Exception {
    String id = serverRequest.pathVariable("id");
    log.info("查询用户信息完成" + "用户id:" + id);
    //业务处理
    Person person = new Person(1L, "小狐狸", "2388958622@qq.com", 17, "user");
    //构建响应
    return ServerResponse.ok().body(person);
  }

  public ServerResponse getUsers(ServerRequest serverRequest) throws Exception {
    Person p = serverRequest.body(Person.class);
    log.info("查询所有用户信息完成" + "用户展示：" + p);
    List<Person> list = Arrays.asList(
        new Person(1L, "小狐狸", "2388958622@qq.com", 17, "user"),
        new Person(2L, "大头儿子", "1234566667@1q.com", 19, "root"),
        new Person(3L, "黑马警长", "23423423@Qq.com", 16, "HR"),
        new Person(3L, "小羊肖恩", "1243123@Qq.com", 25, "admin"),
        new Person(3L, "小老鼠杰瑞", "1243123@Qq.com", 25, "admin")
    );
    return ServerResponse.ok().body(list);
  }

  public ServerResponse createUser(ServerRequest serverRequest) throws Exception {
    Person p = serverRequest.body(Person.class);
    log.info("保存用户信息完成" + "新增用户：" + p);
    return ServerResponse.ok().build();
  }

  public ServerResponse updateUser(ServerRequest serverRequest) {
    String id = serverRequest.pathVariable("id");
    log.info("更新用户信息完成" + "用户id:" + id);
    return ServerResponse.ok().build();
  }

  public ServerResponse deleteUser(ServerRequest serverRequest) {
    String id = serverRequest.pathVariable("id");
    log.info("删除用户信息完成" + "用户id:" + id);
    return ServerResponse.ok().build();
  }
}

