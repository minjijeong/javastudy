package com.datastructure;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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
        SortConception();
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
