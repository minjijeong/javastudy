package com.programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 상담예약제
 * booked 배열의 길이와 unbooked 배열의 원소는 [hh:mm 형식의 도착 시각, 이름] 형식입니다.
 *
 * booked, unbooked 배열에는 오늘 하루 동안 온 고객의 정보만 주어집니다.
 * [["09:10", "lee"]]	[["09:00", "kim"], ["09:05", "bae"]]	["kim", "lee", "bae"]
 */
public class CustomerCenter {
    public static String[] solution(String[][] booked, String[][] unbooked) {

        StringBuilder result = new StringBuilder();

        int bookedIdx = 0;
        int unBookedIdx = 0;
        String curTime = "00:00";

        while(bookedIdx < booked.length || unBookedIdx < unbooked.length){
            // 미예약 손님 모두 처리한 경우
            if(bookedIdx >= booked.length){
                curTime = unbooked[unBookedIdx][0];
                result.append(unbooked[unBookedIdx][1]);
                result.append(",");
                unBookedIdx++;
            }
            else if(unBookedIdx >= unbooked.length){ // 예약 손님 모두 처리한 경우
                curTime = booked[bookedIdx][0];
                result.append(booked[bookedIdx][1]);
                result.append(",");
                bookedIdx++;
            }
            else { // 손님들이 존재하는 경우
                if(unbooked[unBookedIdx] != null && booked[bookedIdx] != null) {
                    int compareResult = compareTime(booked[bookedIdx][0], unbooked[unBookedIdx][0], curTime);
                    if (compareResult <= 0) {
                        curTime = unbooked[unBookedIdx][0];
                        result.append(unbooked[unBookedIdx][1]);
                        result.append(",");
                        unBookedIdx++;
                    }
                    else{
                        curTime = booked[bookedIdx][0];
                        result.append(booked[bookedIdx][1]);
                        result.append(",");
                        bookedIdx++;
                    }
                }
            }
            System.out.println(result.toString());
        }
        String[] answer = result.toString().split(",");
        return answer;
    }
    public static int compareTime(String bookStr1, String unBookStr2, String curTime){
        System.out.printf(" book : %s, unbook : %s , curTime : %s \n",bookStr1,unBookStr2,curTime );
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date book = new Date();
        Date unbook = new Date();
        Date now = new Date();
        try {
            book = format.parse(bookStr1);
            unbook = format.parse(unBookStr2);
            now = format.parse(curTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int compare = book.compareTo(unbook);

        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.MINUTE,10);
        System.out.printf("%s, %s,  %s\n",book, unbook, cal.getTime());
        if(compare > 0){
            int comparewithNow = cal.getTime().compareTo(book);
            System.out.printf("%s, %s,  %d",book, cal.getTime(), comparewithNow);
            if(comparewithNow >= 0){
                return 1;
            }
            else{
                return -1;
            }
        }
        else{
            return 1;
        }
    }



    public static void main(String[] args) {
        String[][] booked = {{"09:55", "hae2"},{"10:05", "jee"}};
        String[][] unBooked = {{"10:04", "hee3"}, {"14:07", "eom"}};
        System.out.println(solution(booked, unBooked));
    }

}
