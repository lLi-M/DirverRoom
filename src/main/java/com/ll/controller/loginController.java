package com.ll.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.VO.Pagequery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;


import java.io.IOException;

@Controller
public class loginController {


    @Value("${name}")
    private String truename;

    @Value("${psw}")
    private String truepsw;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, @RequestParam(value = "name", required = true) String name,
                              @RequestParam(value = "password", required = true) String psw,
                              @RequestParam("vaildcode") String vaild) {

        String code = (String) request.getSession().getAttribute("key");
        System.out.println(truename+"+++"+truepsw);
        if (vaild.equals(code)) {
            if (name.equals(truename) && psw.equals(truepsw)) {
                ModelAndView mv = new ModelAndView("start");
                return mv;
            }
            else {
                ModelAndView mv = new ModelAndView("error");
                mv.addObject("error", "用户名或账号密码错误");
                return mv;
            }
        } else {
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("error", "输入的验证码错误");
            return mv;

        }
    }

    @RequestMapping(value = "/forward")
    public String forward() throws IOException {
//        Cookie cookie=new Cookie("","");
//        Cookie[] cookies=req.getCookies();
//       Object ll= request.getAttribute("ll");
//        Integer ll1=(Integer)request.getAttribute("ll");
//        request.removeAttribute("ll");
//        int lll=((Integer) request.getAttribute("ll")).intValue();
       return  "login";

    }

    @RequestMapping(value = "/index")
    public String index() {
        return "login";
    }
}
