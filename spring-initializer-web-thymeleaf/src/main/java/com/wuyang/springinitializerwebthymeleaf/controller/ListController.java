package com.wuyang.springinitializerwebthymeleaf.controller;

import com.wuyang.springinitializerwebthymeleaf.bean.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ListController {
  @GetMapping("/list")
  public String list(Model model) {
    List<Person> list = Arrays.asList(
        new Person(1L,"小狐狸","2388958622@qq.com",17,"user"),
        new Person(2L,"大头儿子","1234566667@1q.com",19,"root"),
        new Person(3L,"黑马警长","23423423@Qq.com",16,"HR"),
        new Person(3L,"小炎子","1243123@Qq.com",25,"admin"),
        new Person(3L,"哦豁",null,25,"admin"),
        new Person(3L,"小羊肖恩","1243123@Qq.com",25,"admin"),
        new Person(3L,"小老鼠杰瑞","1243123@Qq.com",25,"admin")
    );
    model.addAttribute("tablePerson",list);
//    int i = 10/0;
    return "list";
  }


}
