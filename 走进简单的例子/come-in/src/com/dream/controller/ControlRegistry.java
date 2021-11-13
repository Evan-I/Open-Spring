package com.dream.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.stereotype.*;
import com.dream.service.*;

@Controller
public class ControlRegistry {
    private ServiceRegistry serviceRegistry = null;

    @Autowired
    public void setServiceRegistry(ServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
    }

    @ResponseBody
    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public BaseResult visit(WebRequest request) {
        var name = request.getParameter("name");
        var phone = request.getParameter("phone");
        var password = request.getParameter("password");
        var confirm = request.getParameter("confirm");
        return this.serviceRegistry.process(name, phone, password, confirm);
    }
}