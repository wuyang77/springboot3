package com.wuyang.springinitializerwebthymeleaf.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

@Component
public class YamlHttpMessagerConverter extends AbstractHttpMessageConverter {
  private ObjectMapper objectMapper = null;//把对象转换成yaml


  public YamlHttpMessagerConverter() {
    //媒体类型
    super(new MediaType("text","yaml",Charset.forName("UTF-8")));
    YAMLFactory yamlFactory = new YAMLFactory().disable(Feature.WRITE_DOC_START_MARKER);
    this.objectMapper = new ObjectMapper(yamlFactory);
  }

  @Override
  protected boolean supports(Class clazz) {
    //只要是对象类型，不是基本类型
    return true;//自定义消息转化器，一定要开启支持，设置为true
  }

  @Override  //@RequestBody 把对象怎么写进来
  protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
    return null;
  }

  @Override //@ResponseBody 把对象怎么写出去
  protected void writeInternal(Object methodReturnValue,HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
    //try with 的写法，自动关留
    try(OutputStream body = outputMessage.getBody()) {
      this.objectMapper.writeValue(body,methodReturnValue);
    }
  }
}
