package com.wuyang.springinitializerwebthymeleaf.controller;

import com.wuyang.springinitializerwebthymeleaf.service.Aservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

  @Autowired
  Aservice aservice;



  @GetMapping("/well")
  public String welcome(@RequestParam String name, Model model) {
    aservice.a();
    String text = "<span style='color:red'>"+name+"</span>";
    Integer age = 11;
    //逻辑视图：视图名 index
    //物理视图：前缀+视图名+后缀
    //classpath:/templates/+index+.html";
    model.addAttribute("age",age);
    model.addAttribute("msg",text);
    model.addAttribute("msg2",text);
    model.addAttribute("imgUrl","prefix/4.png");
    model.addAttribute("style","width:200px");
    model.addAttribute("show",false);
    return "welcome";
  }


  @GetMapping("/")
  public String index() {
    return "index";
  }
}
