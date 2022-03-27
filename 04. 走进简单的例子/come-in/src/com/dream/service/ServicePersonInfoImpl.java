package com.dream.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.dream.repository.*;
import com.dream.*;

@Service
public class ServicePersonInfoImpl implements ServicePersonInfo {
    private QueryPersonById queryPersonById = null;

    @Autowired
    public void setQueryPersonById(QueryPersonById queryPersonById) {
        this.queryPersonById = queryPersonById;
    }

    @Override
    public ServicePersonInfoResult process(String personId) {
        var id = Converter.toInteger(personId);
        if (id == null) {
            return new ServicePersonInfoResult(ErrorCode.ERROR_FATAL);
        }

        var person = this.queryPersonById.access(id);
        if (person == null) {
            return new ServicePersonInfoResult(ErrorCode.ERROR_CREDENTIAL);
        }

        var personInfoResult = new ServicePersonInfoResult(ErrorCode.SUCCESS);
        personInfoResult.setPersonId(person.getPersonId());
        personInfoResult.setPersonName(person.getPersonName());
        personInfoResult.setPersonTime(person.getPersonTime());
        return personInfoResult;
    }
}