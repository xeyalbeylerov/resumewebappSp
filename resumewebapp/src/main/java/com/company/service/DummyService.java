package com.company.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DummyService {
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void foo(){
        System.out.println("Foo calling admin");
    }
    public void foo2(){
        System.out.println("Foo calling user");
    }
}
