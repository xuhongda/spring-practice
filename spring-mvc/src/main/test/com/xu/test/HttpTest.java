package com.xu.test;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuhongda on 2021/5/10
 * com.xu.test
 * spring-practice
 */
public class HttpTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int j = 0; j <20 ; j++) {
            executorService.submit(()->{
                for (int i = 0; i <401000 ; i++) {
                    //请求头
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                    //请求参数
                   // MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
                    HttpEntity<MultiValueMap> httpEntity = new HttpEntity<>(null,headers);
                    // String url = "http://localhost:8017/getGirl";
                    String url = "https://www.cugb.edu.cn/content/view?contentId=41001";
                    RestTemplate restTemplate = new RestTemplate();
                    // exchange 方法
                    ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

                }
            });
        }


        executorService.shutdown();
    }
}
