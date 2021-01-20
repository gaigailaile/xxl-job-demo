package com.gai.xxljobdemo.Utils;

import com.gai.xxljobdemo.entity.XxlJobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class HttpUtil {

    public static String doPost1(){
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("jobGroup","3");
        param.add("jobDesc","xxl-job-demo 创建");
        param.add("executorRouteStrategy","FIRST");
        param.add("jobCron","* 1-2 * * * ?");
        param.add("glueType","BEAN");
        param.add("executorHandler","demoJobHandler");
        param.add("executorBlockStrategy","SERIAL_EXECUTION");
        param.add("executorTimeout","0");
        param.add("executorFailRetryCount","0");
        param.add("author","gaigaicoming");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8080/xxl-job-admin/jobinfo/add", param, String.class);
        String body = responseEntity.getBody();

        return responseEntity.getBody();
    }

    public static String doPost2(String url, XxlJobInfo xxlJobInfo){
        RestTemplate restTemplate = new RestTemplate();

        Object object = restTemplate.postForObject(url,xxlJobInfo,String.class);

        return object.toString();
    }

    public String doGet(){
        return null;
    }
}
