package com.dream.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.stereotype.*;
import com.dream.service.*;

@Controller
public class ControlLogon {
    private ServiceLogon serviceLogon = null;

    @Autowired
    public void setServiceLogon(ServiceLogon serviceLogon) {
        this.serviceLogon = serviceLogon;
    }

    @ResponseBody
    @RequestMapping(value = "/logon", method = RequestMethod.POST)
    public ServiceLogonResult visit(WebRequest request) {
        var phone = request.getParameter("phone");;
        var password = request.getParameter("password");
        return this.serviceLogon.process(phone, password);
    }
}