package com.dream.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.dream.repository.*;
import com.dream.*;

@Service
public class ServiceLogonImpl implements ServiceLogon {
    private QueryPersonIdByCredential queryPersonIdByCredential = null;

    @Autowired
    public void setQueryPersonIdByCredential(QueryPersonIdByCredential queryPersonIdByCredential) {
        this.queryPersonIdByCredential = queryPersonIdByCredential;
    }

    @Override
    public ServiceLogonResult process(String phone, String password) {
        if (!Validator.validatePersonPhone(phone)) {
            return new ServiceLogonResult(ErrorCode.ERROR_FATAL);
        }
        if (!Validator.validatePersonPassword(password)) {
            return new ServiceLogonResult(ErrorCode.ERROR_FATAL);
        }

        var personId = queryPersonIdByCredential.access(phone, password);
        if (personId <= 0) {
            return new ServiceLogonResult(ErrorCode.ERROR_CREDENTIAL);
        }

        var serviceResult = new ServiceLogonResult(ErrorCode.SUCCESS);
        serviceResult.setPersonId(personId);
        return serviceResult;
    }
}