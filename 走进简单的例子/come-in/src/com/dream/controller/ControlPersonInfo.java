package com.dream.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.stereotype.*;
import com.dream.service.*;

@Controller
public class ControlPersonInfo {
    private ServicePersonInfo servicePersonInfo = null;

    @Autowired
    public void setServicePersonInfo(ServicePersonInfo servicePersonInfo) {
        this.servicePersonInfo = servicePersonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/person_info", method = RequestMethod.POST)
    public ServicePersonInfoResult visit(WebRequest request) {
        var personId = request.getParameter("personId");
        return this.servicePersonInfo.process(personId);
    }
}
