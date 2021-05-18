package com.xu.test;

import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xuhongda on 2021/5/10
 * com.xu.test
 * spring-practice
 */
public class HttpTest {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);


        //请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //请求参数
        // MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap> httpEntity = new HttpEntity<>(null,headers);
        // String url = "http://localhost:8017/getGirl";
        String url = "https://www.cugb.edu.cn/content/view?contentId=41001";
        RestTemplate restTemplate = new RestTemplate();

        for (int j = 0; j <10 ; j++) {
            executorService.submit(()->{
                for (int i = 0; i <1*100 ; i++) {
                    restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);
                }
            });
        }



        scheduledExecutorService.scheduleAtFixedRate(()->{
            ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);
            Map body = exchange.getBody();
            Map<String,Integer> data = (Map)body.get("data");
            Integer view = data.get("views");
            System.out.println(view);
            if (view > 520*10000){
                System.out.println(view);
                executorService.shutdownNow();
                scheduledExecutorService.shutdownNow();
            }
        },0,10, TimeUnit.SECONDS);


        executorService.shutdown();
    }
}
