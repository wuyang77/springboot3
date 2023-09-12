package com.wuyang.springbootrpc.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface ExpressInterface {

  @GetExchange(value = "https://wuliu.market.alicloudapi.com/kdi",accept = "application/json")
  Mono<String> getExpress(@RequestParam("no") String number);

}
