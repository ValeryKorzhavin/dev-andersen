package com.company.service;

import com.company.annotations.CachedClass;

@CachedClass
public class ComputeService implements Service {

    @Override
    public int doHardWork(int a, int b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
        return a + b;
    }

}
