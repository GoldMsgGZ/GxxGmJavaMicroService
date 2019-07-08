package com.baggio.dubboserver.service.impl;

import com.baggio.dubboserver.service.ComputeService;

public class ComputeServiceImpl implements ComputeService {
    @Override
    public Integer add(int a, int b) {
        return a + b;
    }
}
