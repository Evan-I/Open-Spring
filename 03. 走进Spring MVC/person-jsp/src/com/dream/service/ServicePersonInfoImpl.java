package com.dream.service;

import java.util.*;
import com.dream.repository.*;

public class ServicePersonInfoImpl implements ServicePersonInfo {
    @Override
    public List<ServicePersonInfoResult> process() {
        var personInfoResultList = new ArrayList<ServicePersonInfoResult>();
        var queryPerson = new QueryPersonImpl();
        var queryPersonOutList = queryPerson.access();
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