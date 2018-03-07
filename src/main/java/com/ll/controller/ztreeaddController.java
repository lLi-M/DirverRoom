package com.ll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ds")
@Controller
public class ztreeaddController {

    @RequestMapping("/trainer")
    public String trainer() {

        return "trainer";
    }

    @RequestMapping("/lookusertime")
    public String lookusertime() {

        return "lookusertime";
    }

    @RequestMapping("/testpeople")
    public String testpeople() {

        return "testpeople";
    }

    @RequestMapping("/changepassword")
    public String changePassword() {
        return "changepassword";
    }

    @RequestMapping("/getappointment")
    public String getappointment() {

        return "appointment";
    }

    @RequestMapping("/textarea")
    public String gettextarea() {

        return "writeTextarea";
    }
}
