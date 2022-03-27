package com.dream.service;

import com.dream.*;

public class BaseResult {
    private ErrorCode errorCode = ErrorCode.SUCCESS;

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public BaseResult(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}