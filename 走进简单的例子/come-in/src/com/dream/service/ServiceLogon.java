package com.dream.service;

public interface ServiceLogon {
    ServiceLogonResult process(String phone, String password);
}