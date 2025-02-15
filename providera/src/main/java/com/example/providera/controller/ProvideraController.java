package com.example.providera.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProvideraController {

    @Value("${star.color:blue}")  // 从环境变量读取
    private String starColor;

    @Value("${star.count:3}")     // 从环境变量读取
    private int starCount;

    @GetMapping("/data")
    public Map<String, Object> getData() {
        Map<String, Object> result = new HashMap<>();
        try {
            InetAddress host = InetAddress.getLocalHost();
            result.put("serviceName", "ProviderA");
            result.put("hostName", host.getHostName());
            result.put("ipAddress", host.getHostAddress());
            result.put("stars", Collections.nCopies(starCount, starColor));
        } catch (Exception e) {
            result.put("error", "无法获取主机信息");
        }
        return result;
    }
}
