package com.ismart.controller;


import com.ismart.service.ISmartService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/ismart")
public class ISmartController {

    @Resource
    ISmartService iSmartService;

    @GetMapping("/ut")
    public String getUt(String str, int i) {
        return iSmartService.enc(str, i);
    }

}
