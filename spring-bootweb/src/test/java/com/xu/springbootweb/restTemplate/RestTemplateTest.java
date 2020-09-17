package com.xu.springbootweb.restTemplate;

import com.xu.pojo.Girl;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhongda on 2020/9/16
 * com.xu.springbootweb.restTemplate
 * spring-practice
 */
public class RestTemplateTest {

    /**
     *  RestTemplate post 请求
     */
    @Test
    public void test001(){

        //请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //请求参数
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("s1","hello");
        parts.add("s2","world");


        HttpEntity<MultiValueMap> httpEntity = new HttpEntity<>(parts,headers);
        String url = "http://localhost:8017/hello2";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);

        System.out.println(responseEntity.toString());
        System.out.println(responseEntity.getBody());

        String object = restTemplate.postForObject(url, httpEntity, String.class);
        System.out.println("str object "+object);

        // exchange 方法
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println(exchange.getBody());
    }


    @Test
    public void test002(){


        Map<String, String> vars = new HashMap<>();
        vars.put("s1","hello");
        vars.put("s2","world");
        //uri 参数
        String url = "http://localhost:8017/hello1?s1={s1}&s2={s2}";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class,vars);
        System.out.println(result);
    }





    /**
     *  restTemplate get 请求推荐写法
     */

    @Test
    public void test003(){

        //请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap> httpEntity = new HttpEntity<>(headers);
        //uri 参数
        String url = "http://localhost:8017/getGirl?name={name}";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Girl> exchange = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Girl.class,"liu");
        System.out.println(exchange.getBody().getName());

    }
}
