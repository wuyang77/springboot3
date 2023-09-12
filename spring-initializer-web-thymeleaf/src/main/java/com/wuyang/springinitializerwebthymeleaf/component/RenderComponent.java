package com.wuyang.springinitializerwebthymeleaf.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

@Component("Aaaa")//视图名就是组件名
public class RenderComponent implements View {

  @Override
  public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.getWriter().write("渲染");
  }
}
