package com.design_pattern.factory_method.java;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class CalendarExample {
    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().getClass()); // java.util.GregorianCalendar
        // Calendar Overloading 하여 실행
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("th-TH-x-lvariant-TH"))); // sun.util.BuddhistCalendar
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("ja-JP-x-lvariant-JP"))); // java.util.JapaneseImperialCalendar

        // NumberFormat Overloading Instance를 별도로 구현
        NumberFormat nf1 = NumberFormat.getInstance();
        System.out.println(nf1.getClass());
        System.out.println(nf1.format(3000000));
        NumberFormat nf2 = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(nf2.getClass());
        System.out.println(nf2.format(2000000));
        NumberFormat nf3 = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        System.out.println(nf3.getClass());
        System.out.println(nf3.format(30000000));
    }
}
