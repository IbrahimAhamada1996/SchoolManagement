package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.services.SlugService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SlugServiceImp implements SlugService {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
