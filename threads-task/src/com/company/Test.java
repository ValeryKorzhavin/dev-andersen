package com.company;

import java.util.HashSet;
import java.util.Set;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.Arrays;

/**
 * Необходимо уменьшить время выполнения вычислений.
 * <p>
 * Можно изменять этот класс или добавить новый. Решение должно быть максимально простым, без использования экзекуторов.
 * (Runnable, Threads). Аккуратно обработайте потенциальные ошибки (разумеется вычисления если появились ошибки нужно
 * остановить). Количество потоков должно быть ограничено значением константы com.company.TestConsts#MAX_THREADS.
 */
public class Test {

    private static final Logger log = Logger.getLogger(Test.class.getName());

    private static Integer task = TestConsts.N;

    private static Set<Double> result = new HashSet<>();

    private static volatile boolean hasError = false;

    private static class Worker implements Runnable {
        @Override
        public void run() {
            while (!hasError) {
                try {    
                    final int currentTask;
                    synchronized (task) {
                        currentTask = --task;
                        if (currentTask < 0) { 
                            break; 
                        }
                    }

                    Set<Double> resultPart = 
                        TestCalc.calculate(currentTask);

                    synchronized (result) {
                        result.addAll(resultPart);
                    }
                } catch (TestException ex) {
                    hasError = true;
                } finally {
                    synchronized (result) {
                        result.notify();
                    }
                }
            }
        }
    };

    public static void main(String[] args) throws TestException, 
        InterruptedException {

        for (int i = 0; i < TestConsts.MAX_THREADS; i++) {
            new Thread(new Worker()).start();
        }

        while (task > 0 && !hasError) {
            synchronized (result) {
                result.wait();
            }
        }
        
        log.info(Arrays.toString(result.toArray()));
        if (hasError) {
            log.severe("error occurred during calculations");
        }
    }

}
