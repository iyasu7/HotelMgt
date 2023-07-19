package com.iyex.hotelmgt.utils;

import com.iyex.hotelmgt.domain.Booking;

public class EmailUtil {
    public static String getUserCreatedEmailMessage(String name,String host,String confirmLink){
        return "Hello "+name+"\n\nYour new account has been created. Please click the link below to verify your account\n\n"+gerVerificationUrl(host,confirmLink)+"\n\nIyasu Yonas";
    }

    public static String gerVerificationUrl(String host, String confirmLink) {
        return host +"/api/auth?confirmLink="+confirmLink;
    }
    public static String getLessThanThreeHoursEmailMessage(Booking booking) {
        return "Hello "+booking.getUser().getFirstName()+" "+booking.getUser().getLastName()+"\n\nYour booking with "+booking+" will expire in less than 3 hours\n"
                +"in Hotel "+booking.getHotel().getHotelName()+" On "+booking.getBookingDate()+"\n"
                +"Your have till "+booking.getBookingDate().plusHours(booking.getHotel().getReservationTimeForBookingToExpire())
                +"Please pay your booking fee before it expire.";
    }
}

