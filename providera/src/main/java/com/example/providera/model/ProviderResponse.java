package com.example.providera.model;

import java.util.List;

public class ProviderResponse {
    private String serviceName;
    private String hostName;
    private String ipAddress;
    private List<String> stars;

    // 构造函数
    public ProviderResponse() {}

    public ProviderResponse(String serviceName, String hostName, String ipAddress, List<String> stars) {
        this.serviceName = serviceName;
        this.hostName = hostName;
        this.ipAddress = ipAddress;
        this.stars = stars;
    }

    // Getter 和 Setter 方法
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public List<String> getStars() {
        return stars;
    }

    public void setStars(List<String> stars) {
        this.stars = stars;
    }
}
