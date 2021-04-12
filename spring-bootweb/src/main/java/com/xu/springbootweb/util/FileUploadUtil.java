package com.xu.springbootweb.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author xuhongda on 2021/3/18
 * com.xu.springbootweb.util
 * spring-practice
 */
public class FileUploadUtil {

    private String http(String url, MultipartFile[] files, Map map, HttpMethod method) throws IOException {
        //请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(map);
        MultiValueMap<String,Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("number","123");
        multiValueMap.add("status",1);
        for (MultipartFile file : files){
            File file1= new File("D:\\xucode\\dina\\iov-vs-api\\"+file.getOriginalFilename());
            file.transferTo(file1);
            FileSystemResource fileSystemResource = new FileSystemResource(file.getOriginalFilename());
            multiValueMap.add("imgs",fileSystemResource);
        }
        HttpEntity<Object> httpEntity = new HttpEntity<>(multiValueMap,headers);
        RestTemplate restTemplate = new RestTemplate();
        // exchange 方法
        ResponseEntity<String> exchange = restTemplate.exchange(url, method, httpEntity, String.class);
        System.out.println(exchange.getBody());
        return exchange.getBody();
    }
}
