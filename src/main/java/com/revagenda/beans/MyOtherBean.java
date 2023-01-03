package com.revagenda.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyOtherBean {
    private MyLastBean lastBean;

    @Autowired
    public MyOtherBean(MyLastBean lastBean) {
        System.out.println("MyOtherBean constructor...");
        this.lastBean = lastBean;
    }

    public void test() {
        lastBean.test();
        System.out.println("MyOtherBean test.");
    }


}
