package com.revagenda.demobeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements Lifecycle {
    private MyOtherBean otherBean;
    private boolean isRunning;


    @Autowired
    public MyBean(MyOtherBean otherBean) {
        System.out.println("MyBean constructor...");
        this.otherBean = otherBean;
        isRunning = false;
    }

    public void test() {
        System.out.println("MyOtherBean test.");
        otherBean.test();
    }

    @Override
    public void start() {
        System.out.println("MyBean start method...");
    }

    @Override
    public void stop() {
        System.out.println("MyBean stop method...");
    }

    @Override
    public boolean isRunning() {
        return this.isRunning;
    }
}
