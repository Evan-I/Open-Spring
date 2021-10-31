package com.dream.controller;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.*;
import com.dream.service.*;

@Controller
public class ControlPersonInfo {
    private ServicePersonInfo servicePersonInfo = null;

    @Autowired
    public void setServicePersonInfo(ServicePersonInfo servicePersonInfo) {
        this.servicePersonInfo = servicePersonInfo;
    }

    @RequestMapping(value = "/person_info", method = RequestMethod.GET)
    public ModelAndView visit(WebRequest request) {
        var modelAndView = new ModelAndView("index");
        var personList = this.servicePersonInfo.process();
        if (personList != null) {
            modelAndView.addObject("personList", personList);
        }
        return modelAndView;
    }
}