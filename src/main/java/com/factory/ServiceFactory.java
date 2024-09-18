package com.factory;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ServiceFactory {

    private final Map<Class<?>, Object> services = new ConcurrentHashMap<>();

    public ServiceFactory(Map<Class<?>, Object> serviceMap) {
        this.services.putAll(serviceMap);
    }

    public <T> T getService(Class<T> serviceClass) {
        // Safe cast with the assumption that the service map contains the correct types
        return serviceClass.cast(services.get(serviceClass));
    }
}
