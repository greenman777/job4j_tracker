package ru.job4j.early;

import java.text.DecimalFormat;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Passport must not be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password length must be in the range [8, 32]");
        }
        boolean upper = false;
        boolean lower = false;
        boolean digital = false;
        boolean special = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upper = true;
            }
            if (Character.isLowerCase(ch)) {
                lower = true;
            }
            if (Character.isDigit(ch)) {
                digital = true;
            }
            if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                special = true;
            }
            if (upper && lower && digital && special) {
                break;
            }
        }
        if (!upper) {
            throw new IllegalArgumentException("Password must contain at least one uppercase character");
        }
        if (!lower) {
            throw new IllegalArgumentException("Password must contain at least one lowercase character");
        }
        if (!digital) {
            throw new IllegalArgumentException("Password must contain at least one number");
        }
        if (!special) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }
        String[] banString = {"qwerty", "12345", "password", "admin", "user"};
        for (String ban : banString) {
            if (password.toLowerCase().contains(ban)) {
                throw new IllegalArgumentException("Password must not contain words: \"qwerty\", \"12345\", \"password\", \"admin\", \"user\"");
            }
        }
        System.out.println("SSS" + "\t");
        return password;
    }

}