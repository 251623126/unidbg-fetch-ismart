package com.ismart.controller;


import com.ismart.service.ISmartService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class IsmartController {

    @Resource
    ISmartService iSmartService;

    @PostMapping(value = "/ismart")
    public String getUt(String str, int i) {
        return iSmartService.enc(str, i);
    }

}
