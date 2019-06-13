package com.baggio.config.controller;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.DynamicMBean;

@RestController
@RequestMapping("/archaius/test")
public class TestController {
    @RequestMapping("/getAnimalName")
    public String getAnimalName() {
        DynamicStringProperty dsp = DynamicPropertyFactory.getInstance().getStringProperty("animal.name", "cat");

        return dsp.get();
    }
}
