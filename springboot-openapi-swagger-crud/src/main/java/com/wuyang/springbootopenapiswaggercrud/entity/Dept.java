package com.wuyang.springbootopenapiswaggercrud.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "部门信息")
public class Dept {
  @Schema(title = "部门id")
  private Long id;
  @Schema(title = "部门名称")
  private String deptName;

}
