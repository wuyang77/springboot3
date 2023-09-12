package com.wuyang.springbootrpc.service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface WeatherInterface {
  @GetExchange(value = "https://ali-weather.showapi.com/area-to-weather-date",accept = "application/json")
  Mono<String> getWeather(@RequestParam("area") String city);
}
