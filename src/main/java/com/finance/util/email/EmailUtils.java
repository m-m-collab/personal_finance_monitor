package com.finance.util.email;

import java.util.regex.Pattern;

/**
 * Email validate util.
 */
public class EmailUtils {

    public static boolean mailValidate(String email){
        String emailPattern = "^[a-zA-Z0-9.!#$%&*]+@[a-zA-Z0-9-]+(:\\.[a-zA-Z0-9-])+$";
        return Pattern.matches(emailPattern, email);
    }
}
