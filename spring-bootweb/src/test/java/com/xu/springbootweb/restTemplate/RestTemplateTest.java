package com.xu.springbootweb.restTemplate;

import com.xu.pojo.Girl;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author xuhongda on 2020/9/16
 * com.xu.springbootweb.restTemplate
 * spring-practice
 */
public class RestTemplateTest {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //请求参数
        //  MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap> httpEntity = new HttpEntity<>(null,headers);
        // String url = "http://localhost:8017/getGirl";
        String url = "https://www.cugb.edu.cn/content/view?contentId=41001";
        RestTemplate restTemplate = new RestTemplate();
        for (int j = 0; j <500 ; j++) {
            executorService.submit(()->{
                for (int i = 0; i <401000 ; i++) {
                    restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

                }
            });
        }


        executorService.shutdown();
    }

    /**
     *  RestTemplate post 请求
     */
    @Test
    public void test001(){


        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int j = 0; j <5 ; j++) {
            executorService.submit(()->{
                for (int i = 0; i <401000 ; i++) {

                    //请求头
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                    //请求参数
                    MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
                    //  parts.add("name","liu");
                    // parts.add("s2","world");


                    HttpEntity<MultiValueMap> httpEntity = new HttpEntity<>(parts,headers);
                    // String url = "http://localhost:8017/getGirl";
                    String url = "https://www.cugb.edu.cn/content/view?contentId=41001";
                    RestTemplate restTemplate = new RestTemplate();
       /* ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);

        System.out.println(responseEntity.toString());
        System.out.println(responseEntity.getBody());

        String object = restTemplate.postForObject(url, httpEntity, String.class);
        System.out.println("str object "+object);*/

                    // exchange 方法
                    ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
                    //System.out.println(exchange.getBody());
                }
            });
        }





        executorService.shutdown();





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
