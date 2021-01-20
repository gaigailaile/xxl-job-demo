package com.gai.xxljobdemo.controller;

import com.gai.xxljobdemo.Utils.HttpUtil;
import com.gai.xxljobdemo.entity.XxlJobInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/add")
    public String add(){
        String code = HttpUtil.doPost1();
        return code;
    }

    @PostMapping("/add2")
    public String add2(XxlJobInfo xxlJobInfo){
        String code = HttpUtil.doPost2("http://localhost:8080/xxl-job-admin/jobinfo/addJob",xxlJobInfo);
        return code;
    }
}
