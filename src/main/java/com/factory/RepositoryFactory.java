package com.factory;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RepositoryFactory {

    private final Map<Class<?>, Object> repositories = new ConcurrentHashMap<>();

    public RepositoryFactory(Map<Class<?>, Object> repositoryMap) {
        this.repositories.putAll(repositoryMap);
    }

    @SuppressWarnings("unchecked")
	public <T> T getRepository(Class<T> repositoryClass) {
        return (T) repositories.get(repositoryClass);
    }
}
