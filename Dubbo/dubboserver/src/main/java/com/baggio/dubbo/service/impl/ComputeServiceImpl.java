package com.baggio.dubbo.service.impl;

import com.baggio.dubbo.service.ComputeService;

public class ComputeServiceImpl implements ComputeService {
    @Override
    public Integer add(int a, int b) {
        return a + b;
    }
}
