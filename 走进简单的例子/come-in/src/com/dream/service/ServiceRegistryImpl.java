package com.dream.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.dream.repository.*;
import com.dream.*;

@Service
public class ServiceRegistryImpl implements ServiceRegistry {
    private CountPersonByPhone countPersonByPhone = null;
    private AddPerson addPerson = null;

    @Autowired
    public void setCountPersonByPhone(CountPersonByPhone countPersonByPhone) {
        this.countPersonByPhone = countPersonByPhone;
    }

    @Autowired
    public void setAddPerson(AddPerson addPerson) {
        this.addPerson = addPerson;
    }

    @Override
    public BaseResult process(String name, String phone, String password, String confirm) {
        if(!Validator.validatePersonName(name)) {
            return new BaseResult(ErrorCode.ERROR_FATAL);
        }
        if(!Validator.validatePersonPhone(phone)) {
            return new BaseResult(ErrorCode.ERROR_FATAL);
        }
        if(!Validator.validatePersonPassword(password)) {
            return new BaseResult(ErrorCode.ERROR_FATAL);
        }
        if(!password.equals(confirm)) {
            return new BaseResult(ErrorCode.ERROR_FATAL);
        }
        if(this.countPersonByPhone.access(phone) > 0) {
            return new BaseResult(ErrorCode.ERROR_DUPLICATE);
        }

        this.addPerson.access(name, phone, password);
        return new BaseResult(ErrorCode.SUCCESS);
    }
}