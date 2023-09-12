package com.wuyang.springbootrpc.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@Service
public class RpcCommmonApiService {

  @Autowired
  WeatherInterface weatherInterface;
  @Autowired
  ExpressInterface smsInterface;
  public Mono<String> weather(String area) {
    //远程调用阿里云API
    //1.通过WebClient调用
//    Mono<String> weather = getByWebClient(area);
    //2.通过HttpInteface调用
//    Mono<String> weather = getByHttpInteface(area);

    Mono<String> weather = weatherInterface.getWeather(area);
    return weather;
  }

  public Mono<String> sms(String numeber) {
    Mono<String> sms = smsInterface.getExpress(numeber);
    return sms;
  }

  private Mono<String> getByHttpInteface(String area,@Value("${aliyun.appcode}") String appcode) {
    //1、创建客户端
    WebClient client = WebClient.builder()
        .defaultHeader("Authorization","APPCODE "+appcode)
        .baseUrl("https://ali-weather.showapi.com")
        .codecs(clientCodecConfigurer -> {
          clientCodecConfigurer
              .defaultCodecs()
              .maxInMemorySize(256*1024*1024);
          //响应数据量太大有可能会超出BufferSize，所以这里设置的大一点
        })
        .build();
    //2、创建工厂
    HttpServiceProxyFactory factory = HttpServiceProxyFactory
        .builder(WebClientAdapter.forClient(client)).build();
    //3、获取代理对象
    WeatherInterface weatherInterface = factory.createClient(WeatherInterface.class);
    Mono<String> weather = weatherInterface.getWeather(area);
    return weather;
  }

  private static Mono<String> getByWebClient(String area) {

    HashMap<String, String> params = new HashMap<>();
    params.put("area", area);
    WebClient webClient = WebClient.create();
    Mono<String> mono = webClient.get()
        .uri("https://ali-weather.showapi.com/area-to-weather-date?area={area}", params)
        .accept(MediaType.APPLICATION_JSON)
        .header("Authorization", "APPCODE eafa64e56d5a4e9d9cc091f9c54302d1")
        .retrieve()
        .bodyToMono(String.class);
    return mono;
  }
}
