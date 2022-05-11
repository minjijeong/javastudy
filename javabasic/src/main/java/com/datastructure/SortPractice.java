package com.datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;
import sun.awt.image.ImageWatched.Link;

/**
 * [Sort 종류]
 * 1. 버블정렬 O(n^2)
 * - 이중 for문을 활용하여 옆으로 한칸씩 옮겨가며 비교하여 순서를 정한다.
 *
 * 2. 삽입정렬 Insertion Sort O(n^2)
 * - 처음 항 고정후 다음 항부터 앞쪽에 있는 것들과 비교해서 앞의 것들 가운데 삽입하여 정렬
 *
 * 3. 선택정렬 Selection sort O(n^2)
 * - 전체 데이타에서 가장 최소값을 찾아 가장 왼쪽에 둔다.
 * - 남은 범위에서 가장 최소값을 다시 그 왼쪽 뒤에 붙인다. 이러한 방식 반복처리
 *
 * 4. 쿽소트 Quick Sort O(nlogn)
 * - 큰것과 작은것을 구분하여 정렬
 * - Pivot을 선택하여 그것보다 큰값과 작은값으로 2개의 그룹으로 나눔
 * - 그리고 또 각각 그룹에서 Pivot 값을 정하여 다시 그룹핑. 해당 액션 반복 후 모든 데이타 순서대로 합치기
 *
 * 5. 병합정렬 Merge Sort O(nlogn)
 * - 임의의 기준으로 절반으로 나눈다.
 * - 1개씩이 될때까지 계속 나눈다.
 * - 같은곳에서 나온것부터 합친다. 작은값을 먼저 올리고 큰값을 뒤에 올린다.
 * - 최종 그룹의 가장 왼쪽부터 서로 비교하여 나열하여 올린다.
 *
 * [Comparator]
 * - naturalOrder(오름차순), reverseOrder(내림차순)
 * -
 */
public class SortPractice {
    public static void main(String[] args) {
//        SortConception();
//        removeTheLeastNumber();
//        customOrderStrings();
//        jadenCaseString();
        hIndex();
    }

    private static void hIndex() {
        int[] citations= {3, 0, 6, 1, 5};

        // 기대값 3
        System.out.println(solution04(citations));
    }

    private static int solution04(int[] citations) {
        // n편중 h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면, h의 최대값
        //[10,100] -> 2
        //[6,6,6,6,6,6] -> 6
        //[2,2,2] -> 2
        //[3, 0, 6, 1, 5] -> 3
        //[0,1,3,5,6]
        int answer = 0;
        Arrays.sort(citations);
        int size = citations.length;
//        int idx = (int)Math.ceil(citations.length/2);
        Queue<Integer> guess = new LinkedList<>();
        for(int j=0; j<size;j++) guess.add(citations[j]);

        System.out.println(guess.peek());
        // size 보다 모두 크거나 같다면 사이즈 = h
        if(size <= guess.peek()){
            answer = size;
        }

        int minDiff = 0;
        int idx = 0;
        while (!guess.isEmpty()){
            int lessRefCnt = 0; // h번 이하 논문수
            int greatRefCnt = 0; // h번 이상 논문수
            int current = guess.poll();
            // for문으로 다음 항이 현재 항보다 큰 개수가 현재항보다 많다면 h
            for(int i=idx+1;i <citations.length;i++){
                if(citations[i] < current){
                    lessRefCnt++;
                }else if(citations[i] > current){
                    greatRefCnt++;
                }else{
                    lessRefCnt++;
                    greatRefCnt++;
                }
            }
            minDiff = Math.min(minDiff, greatRefCnt-lessRefCnt);
            if(minDiff == 0){
                answer = Math.min(answer, greatRefCnt);
            }
//            answer =
            idx++;
        }
        System.out.println(minDiff);
        return answer;
    }

    private static void jadenCaseString() {
        String s = "3people unFollowed me";
        // 기대값 "3people Unfollowed Me"
        System.out.println(solution03(s));
    }
    public static String solution03(String s) {
        // 모든 단어의 첫 문자가 대문자이고 - index 0 이거나 or space 뒤에 오는 문자는 대문자 치환
        // 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다.
        // 그 외의 알파벳은 소문자인 문자열
        StringBuffer buffer = new StringBuffer();
        int chkBefore = 32;
        for(char c : s.toLowerCase().toCharArray()){
            // 32 : 공백 , 65 : A, 122 : z
            if(chkBefore == 32 && c >= 65 && c <= 122){
                c -= 32;
            }

            chkBefore = c;
            buffer.append(c);
        }
        return buffer.toString();
    }

    private static void customOrderStrings() {
//        String[] strings = {"sun", "bed", "car"};
        String[] strings = {"abce", "abcd", "cdx"};
//        int n = 1;
        int n = 2;
        System.out.println(Arrays.toString(solution02(strings,n)));
    }

    public static String[] solution02(String[] strings, int n) {
        return Arrays.stream(strings).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char str1 = o1.charAt(n);
                char str2 = o2.charAt(n);
                if(str1 == str2){
                    return o1.compareTo(o2);
                }
                return str1 - str2;
            }
        }).toArray(String[]::new);
    }

    private static void removeTheLeastNumber() {
        int[] arr = {4,3,2,1};
        // 기대값 4,3,2
        System.out.println(solution01(arr));
    }

    public static int[] solution01(int[] arr) {
        int[] answer = {-1};
        if(arr.length == 1) return answer;

        int min = Arrays.stream(arr).sorted().toArray()[0];
        List<Integer> list = new LinkedList<>();
        for(int i=0; i<arr.length;i++){
            if(arr[i] != min) list.add(arr[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    static class MyData implements Comparable<MyData>{
        int v;

        public MyData(int v){
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MyData myData = (MyData) o;
            return v == myData.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v);
        }

        @Override
        public String toString(){
            return String.valueOf(v);
        }

        @Override
        public int compareTo(MyData o) {
            return Integer.compare(v, o.v);
        }
    }

    private static void SortConception() {
        List<Integer> list = new LinkedList<>();

        Random r = new Random();
        for(int i = 0 ; i < 20 ; i++ ) list.add(r.nextInt(50)); // 50 미만 값 랜덤 생성

        // 여러가지 알고리즘 배워도 이미 만들어진 sort를 사용한다^^
        list.sort(Comparator.naturalOrder()); // 순정렬
        System.out.println(list);

        list.sort(Comparator.reverseOrder()); // 역순정렬
        System.out.println(list);

        list.sort(new Comparator<Integer>() {
            // 대소관계 재구현 가능
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue() - o2.intValue(); // 오름차순
                // 0 : 같다
                // -1 : 오른쪽이 크다
                // 1 : 왼쪽이 크다
//                return o2.intValue() - o1.intValue(); // 내림차순
            }
        });

        // Ramda 표현식으로 나타낼수 있다.
        list.sort((o1,o2) -> o2.compareTo(o1));

        List<MyData> listMy = new LinkedList<>();

        for(int i=0; i < 20; i++) listMy.add(new MyData(r.nextInt(100)));

        // 객체에서는 Comparator.reverseOrder() 이미구현된 아이는 쓸수가 없어요~
        listMy.sort(new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                return o1.v - o2.v;
            }
        });

        // MyData에 Comparable<MyData> 인터페이스의 compareTo 구현하면 사용가능
        listMy.sort(Comparator.naturalOrder());
        System.out.println(listMy);

        List<MyData> sorted = quickSort(listMy);

    }

    /**
     * 쿽소트 Quick Sort O(nlogn)
     * - 큰것과 작은것을 구분하여 정렬
     * - Pivot을 선택하여 그것보다 큰값과 작은값으로 2개의 그룹으로 나눔
     * - 그리고 또 각각 그룹에서 Pivot 값을 정하여 다시 그룹핑. 해당 액션 반복 후 모든 데이타 순서대로 합치기
     * */
    static List<MyData> quickSort(List<MyData> list){
        if(list.size() <= 1) return list;
        MyData pivot = list.remove(0);

        List<MyData> lesser = new LinkedList<>();
        List<MyData> greater = new LinkedList<>();

        for(MyData m : list){
            if(pivot.compareTo(m) > 0) lesser.add(m);
            else greater.add(m);
        }

        List<MyData> merged = new LinkedList<>();
        merged.addAll(quickSort(lesser));
        merged.add(pivot);
        merged.addAll(quickSort(greater));

        return merged;
    }
}
