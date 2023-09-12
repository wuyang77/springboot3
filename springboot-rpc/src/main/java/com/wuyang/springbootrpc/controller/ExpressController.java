package com.wuyang.springbootrpc.controller;

import com.wuyang.springbootrpc.service.RpcCommmonApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ExpressController {
  @Autowired
  RpcCommmonApiService rpcCommmonApiService;
  @GetMapping("/express")
  public Mono<String> sms(@RequestParam("no") String number) {
    Mono<String> sms = rpcCommmonApiService.sms(number);
    return sms;
  }
}
