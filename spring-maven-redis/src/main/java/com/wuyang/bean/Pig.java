package com.wuyang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pig {
  private String name;
  private Long id;
  private int age;
}
