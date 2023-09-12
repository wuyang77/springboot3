package com.wuyang.springbootopenapiswaggercrud.controller;

import com.wuyang.springbootopenapiswaggercrud.entity.Dept;
import com.wuyang.springbootopenapiswaggercrud.service.DeptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "部门",description = "部门的CRUD")
@RestController
public class DeptController {
  @Autowired
  DeptService deptService;
  @Operation(summary = "按照id查询部门", description = "需要提供id")
  @GetMapping("/dept/{id}")
  public Dept getDept(@PathVariable("id") @Parameter(description = "部门id") Long id) {
    return deptService.getDeptById(id);
  }
  @Operation(summary = "查询所有部门")
  @GetMapping("/depts")
  public List<Dept> getDepts() {
    return deptService.getDepts();
  }
  @Operation(summary = "保存部门", description = "必须提交json")
  @PostMapping("/dept")
  public String saveDept(@RequestBody Dept dept) {
    deptService.saveDept(dept);
    return "ok";
  }
  @Operation(summary = "按照id删除部门", description = "需要提供id")
  @DeleteMapping("/dept/{id}")
  public String deleteDept(@PathVariable("id") @Parameter(description = "部门id") Long id) {
    deptService.deleteDept(id);
    return "ok";
  }
}
