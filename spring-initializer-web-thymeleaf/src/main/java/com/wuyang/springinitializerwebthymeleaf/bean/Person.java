package com.wuyang.springinitializerwebthymeleaf.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement //可以写出为xml文档
public class Person {
  private Long id;
  private String userName;
  private String email;
  private Integer age;
  private String role;
}
