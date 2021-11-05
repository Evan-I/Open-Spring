package com.dream.service;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import com.dream.repository.*;

@Service
public class ServicePersonInfoImpl implements ServicePersonInfo {
    private QueryPerson queryPerson = null;

    @Autowired
    public void setQueryPerson(QueryPerson queryPerson) {
        this.queryPerson = queryPerson;
    }

    @Override
    public List<ServicePersonInfoResult> process() {
        var personInfoResultList = new ArrayList<ServicePersonInfoResult>();
        var queryPersonOutList = this.queryPerson.access();
        if (queryPersonOutList != null) {
            for (var queryPersonOut : queryPersonOutList) {
                var personInfoResult = new ServicePersonInfoResult();
                personInfoResult.setId(queryPersonOut.getId());
                personInfoResult.setName(queryPersonOut.getName());
                personInfoResult.setGender(queryPersonOut.getGender());
                personInfoResultList.add(personInfoResult);
            }
        }
        return personInfoResultList;
    }
}