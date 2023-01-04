package com.revagenda.demobeans;

import org.springframework.stereotype.Component;

@Component
public class MyLastBean {
    public MyLastBean() {
        System.out.println("MyLastBean instance constructor...");
    }

    public void test() {
        System.out.println("MyLastBean test.");

    }
}
