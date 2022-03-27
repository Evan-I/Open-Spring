package com.dream;

import java.util.regex.*;

public final class Validator {
    private static final String PATTERN_PHONE = "^1[0-9]{10}$";

    private Validator() {}

    public static boolean validatePersonName(String value) {
        if (value == null) {
            return false;
        }
        if (value.length() > 12) {
            return false;
        }
        return true;
    }

    public static boolean validatePersonPhone(String value) {
        if (value == null) {
            return false;
        }
        if (!Pattern.compile(PATTERN_PHONE).matcher(value).matches()) {
            return false;
        }
        return true;
    }

    public static boolean validatePersonPassword(String value) {
        if (value == null) {
            return false;
        }
        if (value.length() < 6) {
            return false;
        }
        if (value.length() > 48) {
            return false;
        }
        return true;
    }
}