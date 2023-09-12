package com.wuyang.springinitializerwebthymeleaf.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.RequestContextFilter;

@Service
public class Aservice{
  public void a() {
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    //在任意位置都能获得请求和响应，以后可以能有成千上万个方法
    HttpServletRequest request = requestAttributes.getRequest();
    HttpServletResponse response = requestAttributes.getResponse();
    String uri = request.getRequestURI();
  }

}
