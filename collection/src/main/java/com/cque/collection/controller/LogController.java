package com.cque.collection.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:11:20:25
 */
@RestController
@Slf4j
//         193125Su.5116
public class LogController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/applog")
    public void applog(@RequestParam("param") String jsonStr) {
        log.info(jsonStr);
        kafkaTemplate.send("ods_base_log", jsonStr);
    }
}
