package com.dream.service;

import java.util.*;
import com.dream.*;

public class ServicePersonInfoResult extends BaseResult {
    private int personId = 0;
    private String personName = null;
    private Date personTime = null;

    public int getPersonId() {
        return this.personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return this.personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Date getPersonTime() {
        return this.personTime;
    }

    public void setPersonTime(Date personTime) {
        this.personTime = personTime;
    }

    public ServicePersonInfoResult(ErrorCode errorCode) {
        super(errorCode);
    }
}