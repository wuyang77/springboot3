package com.wuyang.springbootrpc.controller;

import com.wuyang.springbootrpc.service.RpcCommmonApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {

  @Autowired
  RpcCommmonApiService rpcCommmonApiService;


  @GetMapping("/weather")
  public Mono<String> weather(@RequestParam("city") String city) {
    Mono<String> weather =rpcCommmonApiService.weather(city);
    return weather;
  }
}
