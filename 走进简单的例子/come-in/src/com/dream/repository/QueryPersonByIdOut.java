package com.dream.repository;

import java.util.*;

public class QueryPersonByIdOut {
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
}