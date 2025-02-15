package com.example.consumer.controller;

import com.example.consumer.model.ProviderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.a.service_name:providera}")
    private String providerAServiceName;

    @Value("${provider.b.service_name:providerb}")
    private String providerBServiceName;

    @GetMapping("/")
    public String index(Model model) {
        // 调用 Provider A 和 Provider B
        Map<String, Object> providerAData = restTemplate.getForObject(String.format("http://%s:8081/data", providerAServiceName), Map.class);
        Map<String, Object> providerBData = restTemplate.getForObject(String.format("http://%s:8082/data", providerBServiceName), Map.class);

        ProviderResponse providerA = mapToProviderResponse(providerAData);
        ProviderResponse providerB = mapToProviderResponse(providerBData);

        model.addAllAttributes(Map.of("providerA", providerA, "providerB", providerB));

        return "index";
    }

    private ProviderResponse mapToProviderResponse(Map<String, Object> data) {
        if (data == null || (data.containsKey("error"))) {
            return new ProviderResponse("ERROR", "N/A", "N/A", List.of("#FFFFFF"));
        }
        String serviceName = (String) data.get("serviceName");
        String hostName = (String) data.get("hostName");
        String ipAddress = (String) data.get("ipAddress");
        List<Object> starsList = (List<Object>) data.get("stars");
        List<String> stars = starsList.stream().map(Object::toString).toList();

        return new ProviderResponse(serviceName, hostName, ipAddress, stars);
    }
}
