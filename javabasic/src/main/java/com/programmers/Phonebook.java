package com.programmers;

import java.util.Arrays;

public class Phonebook {
    public static void main(String[] args) {
        String[] phonebook = {"119", "97674223", "1195524421"};
        boolean result = solution(phonebook);
        System.out.println(result);
    }
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=0; i< phone_book.length;i++){
            for(int j=i+1; j<phone_book.length;j++){
                if(phone_book[j].length() >= phone_book[i].length()){
                    if(phone_book[j].startsWith(phone_book[i])){
                        return false;
                    }
                    if(phone_book[i].compareToIgnoreCase(phone_book[j].substring(0,phone_book[i].length())) < 0){
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
