package com.company;

import com.company.service.ComputeService;
import com.company.service.Service;

/**
 * Некоторые методы могут выполняться очень долго, хочется иметь возможность кешировать результаты возврата.
 * Например, у нас есть интерфейс Service c методом doHardWork().
 * Повторный вызов этого метода с теми же параметрами должен возвращать рассчитанный результат из кэша.
 * <p>
 * Необходимо реализовать класс CacheProxy с методом cache(), который принимает ссылку на сервис и возвращает кеширующую
 * версию этого сервиса.
 * Результаты вызова метода кеш должен хранить в памяти.
 * Должна быть возможность настройки кеша с помощью аннотаций: кешировать определенные методы или все методы класса.
 * Логика по кешированию должна навешиваться с помощью DynamicProxy.
 * <p>
 * Дизайн аннотаций, классов реализаций на вкус.
 * Код должен быть читаем, классы не перегружены логикой, классы должны лежать в нужных пакетах.
 */
public class Main {

    public static void main(String[] args) {
        CacheProxy proxy = new CacheProxy();
        Service service = proxy.cache(new ComputeService());

        service.doHardWork(3, 2);
        service.doHardWork(3, 2);
        service.doHardWork(3, 2);
    }

}