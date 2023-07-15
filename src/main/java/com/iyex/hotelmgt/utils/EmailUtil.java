package com.iyex.hotelmgt.utils;

public class EmailUtil {
    public static String getUserCreatedEmailMessage(String name,String host,String confirmLink){
        return "Hello "+name+"\n\nYour new account has been created. Please click the link below to verify your account\n\n"+gerVerificationUrl(host,confirmLink)+"\n\nIyasu Yonas";
    }

    private static String gerVerificationUrl(String host, String confirmLink) {
        return host +"/api/auth?confirmLink="+confirmLink;
    }
}

