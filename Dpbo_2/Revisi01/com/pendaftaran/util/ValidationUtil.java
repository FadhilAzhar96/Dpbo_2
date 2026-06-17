package com.pendaftaran.util;

public class ValidationUtil {

    public static boolean isNotBlank(String value) {
        return value != null && !value.isBlank();
    }
}
