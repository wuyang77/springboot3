package com.wuyang.springinitializerwebthymeleaf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import com.wuyang.springinitializerwebthymeleaf.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AntPathMathcer和 PathPatternParser
 * 默认使用新版的 PathPatternParser 进行路径匹配
 * 不能匹配 ** 在中间的情况下，剩下的和 antPathMatcher语法兼容
 */
@Slf4j
@RestController
public class WorldController {
  @GetMapping("/a*/b?/{p1:[a-f]+}/**")
  public String hello(HttpServletRequest request, @PathVariable("p1") String path) {
    log.info("路径变量p1", path);
    String uri = request.getRequestURI();
    return uri;
  }

  @RequestMapping( "/person")
  public Person hello() {
    Person person = new Person();
    person.setId(1L);
    person.setUserName("wuyang");
    person.setEmail("2388958622@qq.com");
    person.setAge(18);
    return person;
  }
  @Autowired
  MessageSource messageSource;
  @GetMapping("/haha")
  public String messages(HttpServletRequest request) {

    Locale locale = request.getLocale();
    String login = messageSource.getMessage("login", null, locale);
    return login;
  }

//  public static void main(String[] args) throws JsonProcessingException {
//    Person person = new Person();
//    person.setId(1L);
//    person.setName("wuyang");
//    person.setEmail("2388958622@qq.com");
//    person.setAge(18);
//    YAMLFactory yamlFactory = new YAMLFactory().disable(Feature.WRITE_DOC_START_MARKER);//禁用了yaml文档的开始标记
//    ObjectMapper objectMapper = new ObjectMapper(yamlFactory);
//    String s = objectMapper.writeValueAsString(person);
//  }

}
