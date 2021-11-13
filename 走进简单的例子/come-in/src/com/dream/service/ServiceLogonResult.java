package com.dream.service;

import com.dream.*;

public class ServiceLogonResult extends BaseResult {
    private int personId = 0;

    public int getPersonId() {
        return this.personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public ServiceLogonResult(ErrorCode errorCode) {
        super(errorCode);
    }
}