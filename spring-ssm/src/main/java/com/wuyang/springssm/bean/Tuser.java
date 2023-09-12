package com.wuyang.springssm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tuser {
  private Long id;
  private String loginName;
  private String nickName;
  private String password;
}
