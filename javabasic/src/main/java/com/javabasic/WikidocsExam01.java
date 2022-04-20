package test.java;

import com.sun.deploy.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WikidocsExam01 {
    /**
     * 03장 자료형 - 연습문제
     * https://wikidocs.net/157658
     */
    public static void main(String [] args) {
        // 01. 평균구하기
        Map<String, Integer> scores = new HashMap<>();
        scores.put("국어",80);
        scores.put("영어",75);
        scores.put("수학",55);

        int tot = 0;
        int idx = 0;
        Set<String> keys = scores.keySet();
        for(String key: keys){
            tot += scores.get(key);
            idx++;
        }
        int avg = tot / scores.size();
        System.out.println("avg :: " + avg);

        // 02. 홀짝수 판별
        int a = 13;
        String check = "";
        if(2 % a == 0){
            check = "짝수";
        }
        else{
            check = "홀수";
        }
        System.out.println(" 확인 :: "+check);

        // 03. 주민번호 쪼개기
        String juminNumber = "881120-1068234";
        String[] jumin = juminNumber.split("-");
        for(String j : jumin) {
            System.out.println(j);
        }
        // 04. 주민번호 성별확인
        System.out.println(juminNumber.charAt(juminNumber.indexOf("-")+1));

        // 05. 문자열 치환
        String str = "a:b:c:d";
        System.out.println(str.replaceAll(":","#"));

        // 06. 리스트 정렬
        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1, 3, 5, 4, 2));
        System.out.println(myList); // [1, 3, 5, 4, 2] 출력
        myList.sort(Comparator.reverseOrder());
        System.out.println(myList);

        // 07. 배열을 문자열로 출력
        ArrayList<String> myListStr = new ArrayList<>(Arrays.asList("Life", "is", "too", "short"));
        String myListString = String.join(" ",myListStr);
        System.out.println(myListStr + "::: "+ myListString );

        // 08.B 값 추출
        HashMap<String, Integer> grade = new HashMap<>();
        grade.put("A", 90);
        grade.put("B", 80);
        grade.put("C", 70);

        System.out.println(grade.remove("B"));

        // 09. 중복값 제거
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5));
        System.out.println(numbers);  // [1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5] 출력
        Set<Integer> newNumbers = new HashSet<>(numbers);
        System.out.println(newNumbers);

        // 10.
        printCoffeePrice(CoffeType.Americano);  // "가격은 3000원 입니다." 출력
        printCoffeePrice(CoffeType.CafeLatte);  // NullPointerException 발생
    }
    enum CoffeType {
        Americano,
        IceAmericano,
        CafeLatte
    };
    static void printCoffeePrice(CoffeType type) {
        HashMap<CoffeType, Integer> priceMap = new HashMap<>();
        priceMap.put(CoffeType.Americano, 3000);  // 1: 아메리카노
        priceMap.put(CoffeType.IceAmericano, 4000);  // 2: 아이스 아메리카노
        priceMap.put(CoffeType.CafeLatte, 5000);  // 3: 카페라떼

        int price = priceMap.get(type);
        System.out.println(String.format("가격은 %d원 입니다.", price));
    }
}
