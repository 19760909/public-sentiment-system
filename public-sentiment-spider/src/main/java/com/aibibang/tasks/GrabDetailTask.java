package com.aibibang.tasks;

import com.aibibang.bean.BasicData;
import com.aibibang.bean.GrabRule;
import com.aibibang.service.GrabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by yanand on 2016/11/1.
 * 抓取任务
 */
@Component
public class GrabDetailTask {
    @Autowired
    private GrabService grabService;

    @Async
    public void grabSubPageAndSave(String url, GrabRule rule) {
        BasicData data = grabService.getBasicData(url, rule);
        grabService.saveDataToHbase(data);
    }
}
