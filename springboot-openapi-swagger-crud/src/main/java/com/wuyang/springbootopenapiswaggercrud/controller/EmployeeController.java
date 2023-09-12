package com.wuyang.springbootopenapiswaggercrud.controller;

import com.wuyang.springbootopenapiswaggercrud.entity.Employee;
import com.wuyang.springbootopenapiswaggercrud.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "员工",description = "员工的CRUD")
@RestController
public class EmployeeController {
  @Autowired
  EmployeeService employeeService;

  @Operation(summary = "按照id查询员工", description = "需要提供id")
  @GetMapping("/employee/{id}")
  public Employee getEmployee(@PathVariable("id") Long id) {
    return employeeService.getEmployeeById(id);
  }
  @Operation(summary = "查询所有的员工")
  @GetMapping("/employees")
  public List<Employee> getDepts() {
    return employeeService.getEmployees();
  }
  @Operation(summary = "添加员工", description = "需要json数据格式")
  @PostMapping("/employee")
  public String saveEmployee(@RequestBody Employee employee) {
    employeeService.saveEmployee(employee);
    return "ok";
  }
  @Operation(summary = "按照id删除员工", description = "需要提供id")
  @DeleteMapping("/employee/{id}")
  public String deleteEmployee(@PathVariable("id") Long id) {
    employeeService.deleteEmployee(id);
    return "ok";
  }
}
