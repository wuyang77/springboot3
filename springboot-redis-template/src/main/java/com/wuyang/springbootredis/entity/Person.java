package com.wuyang.springbootredis.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
  private Long id;
  private String name;
  private Integer age;
  private Date birthDay;

}
