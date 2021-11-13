package com.dream;

import java.util.*;
import java.text.*;

public final class Converter {
    private Converter() {}

    public static Integer toInteger(String value) {
        try {
            return value != null && value.length() > 0 ? Integer.parseInt(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Date toDate(String value) {
        try {
            return value != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value) : null;
        } catch (ParseException e) {
            return null;
        }
    }
}