package com.dream.controller;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import com.dream.service.*;

@Controller
public class ControlPersonInfo {
    private ServicePersonInfo servicePersonInfo = null;

    @Autowired
    public void setServicePersonInfo(ServicePersonInfo servicePersonInfo) {
        this.servicePersonInfo = servicePersonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/person_info", method = RequestMethod.GET)
    public List<ServicePersonInfoResult> visit(WebRequest request) {
        return this.servicePersonInfo.process();
    }
}