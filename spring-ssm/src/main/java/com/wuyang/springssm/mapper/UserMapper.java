package com.wuyang.springssm.mapper;

import com.wuyang.springssm.bean.Tuser;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

  /**
   * 每个方法都在Mapper文件中有一个sql标签
   * 所有参数都应该用@Param进行签名，以后使用指定的名字在SQL中取值
   * @param id
   * @return
   */
  public Tuser getUserById(@Param("id") Long id);
}
