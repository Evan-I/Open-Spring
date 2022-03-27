package com.dream.service;

public interface ServiceRegistry {
    BaseResult process(String name, String phone, String password, String confirm);
}