package com.revagenda.controllers;

import com.revagenda.demobeans.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * This controller was originally included just to respond to pings with pongs. Later we may add some other
 * health checking here.
 */
@Controller
@RequestMapping("/health")
public class HealthController {
    private MyBean myBean;

    @Autowired
    public HealthController(MyBean myBean) {
        System.out.println("Health Controller Constructor...");
        this.myBean = myBean;
    }

    /*
    Remember, for some reason @RequestMapping doesn't work without an explicit @ResponseBody,
    but GetMapping does...
     */
    @GetMapping(value = "/ping")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String ping() {
        return "{\"thing\": \"pong!\"}";
    }


}
