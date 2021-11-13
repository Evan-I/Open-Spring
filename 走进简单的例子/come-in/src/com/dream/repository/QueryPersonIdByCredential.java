package com.dream.repository;

public interface QueryPersonIdByCredential {
    int access(String phone, String password);
}