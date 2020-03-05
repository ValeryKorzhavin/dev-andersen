package com.company;

import com.company.annotations.CachedClass;
import com.company.annotations.CachedMethod;
import com.company.service.Service;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CacheProxy {

    private Map<MethodInfo, Object> storage = new HashMap<>();

    public Service cache(Service service) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(service.getClass());
        enhancer.setCallback((MethodInterceptor) (object, method, args, proxy) -> {
            String methodName = method.getName();
            MethodInfo methodData = new MethodInfo(methodName, args);
            Optional<Annotation> optClassCache = Optional
                .ofNullable(method
                    .getDeclaringClass()
                    .getDeclaredAnnotation(CachedClass.class));
            Optional<Annotation> optMethodCache = Optional
                .ofNullable(method
                    .getAnnotation(CachedMethod.class));

            boolean useCache = optClassCache.isPresent()
                            || optMethodCache.isPresent();
            if (!useCache) {
                return proxy.invokeSuper(object, args);
            }
            if (storage.containsKey(methodData)) {
                return storage.get(methodData);
            }
            Object value = proxy.invokeSuper(object, args);
            storage.put(methodData, value);
            return value;
        });
        return (Service) enhancer.create();
    }

}
