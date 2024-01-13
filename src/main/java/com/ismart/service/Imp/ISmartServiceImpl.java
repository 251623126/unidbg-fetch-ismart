package com.px.unidbg.service.serviceImpl;

import com.px.unidbg.invoke.IsmartSign;
import com.px.unidbg.service.IsmartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IsmartServiceImpl implements IsmartService {

    @Resource
    IsmartSign ismartSign;

    @Override
    public String enc(String str,int i) {
        synchronized (this){
            return ismartSign.enc(str,i);
        }
    }
}
