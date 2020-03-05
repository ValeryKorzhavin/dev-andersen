package com.company;

import com.company.annotations.CachedClass;
import com.company.annotations.CachedMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheProxy<T> {

    private static Map<MethodInfo, Object> storage = new ConcurrentHashMap<>();

    private static class CachingHandler implements InvocationHandler {

        private Object original;

        private CachingHandler(Object original) {
            this.original = original;
        }

        @Override
        public Object invoke(Object proxy, Method method,
                             Object[] args) throws Throwable {
            MethodInfo methodData = new MethodInfo(method.getName(), args);
            Annotation cachedClass = original
                .getClass()
                .getDeclaredAnnotation(CachedClass.class);
            Annotation cachedMethod = original
                .getClass()
                .getAnnotation(CachedMethod.class);

            boolean useCache = cachedClass != null
                            || cachedMethod != null;
            if (!useCache) {
                return method.invoke(original, args);
            }
            if (storage.containsKey(methodData)) {
                return storage.get(methodData);
            }
            Object value = method.invoke(original, args);
            storage.put(methodData, value);
            return value;
        }
    }

    public T cache(T service) {
        Object proxy = Proxy.newProxyInstance(
            service.getClass().getClassLoader(),
            service.getClass().getInterfaces(),
            new CachingHandler(service)
        );
        return (T) proxy;
    }

}
