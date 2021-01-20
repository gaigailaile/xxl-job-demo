package com.gai.xxljobdemo.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class SampleXxlJob {
    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("demoJobHandler")
    public ReturnT<String> demoJobHandler(String param){
//        XxlJobLogger.log("XXL-JOB, Hello World.");
        System.out.println(new Date().toString()+"------"+Thread.currentThread().getName() + ": hello Wrorld");

        for (int i = 0; i < 5; i++) {
            XxlJobLogger.log("beat at:" + i);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ReturnT.SUCCESS;
    }
}
