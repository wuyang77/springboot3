package com.wuyang.springbootopenapiswaggercrud.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Schema(title = "员工信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  @Schema(title = "员工id")
  private Long id;
  @Schema(title = "员工姓名")
  private String name;
  @Schema(title = "员工年龄")
  private Integer age;
  @Schema(title = "员工邮箱")
  private String email;
  @Schema(title = "员工描述")
  private String description;

}
