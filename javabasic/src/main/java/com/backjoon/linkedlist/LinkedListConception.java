package com.backjoon.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 리스트
 * *배열의 문제점을 해결하기 위한 자료구조
 * - 빈틈 없는 데이터 적재, 중간 원소를 삭제 시 뒤 원소들이 빈틈없이 연속적인 위치를 가진다.
 * - 순서가 있는 데이터 모임 또 다른 이름으로 시퀀스라고 부른다.
 * - 빈 엘리먼트는 존재하지 않는다.
 * - 순차성 보장하지 않으므로 cache hit 어렵다.
 * - 리스트는 새로운 노드가 추가되는 런타임에 동적 메모리 할당 된다.
 *
 * [ArrayList]
 * - 배열을 이용해 리스트를 구현
 * - 접근이 빠름, but 데이타 추가와 삭제가 느림 (배열을 이용했기 때문에)
 * - 동적으로 사용하기 힘듬 ( 자바의 경우 Dynamic Array로 사이즈를 지속적으로 조정하여 처리)
 *
 * [LinkedList]
 * - 한 원소에서 값과 다음원소 주소를 알고 연결하는 방식을 가진 리스트
 * - 순차적으로 접근 가능 (배열처럼 랜덤 엑세스 불가능)
 * - 삽입, 삭제 O(1) 이지만, 해당 지점까지 접근해야하므로 W(n)일 수 있음
 * - 배열과 차이로, 논리적 저장 순서와 물리적 저장 순서가 일치하지 않는다.
 * (여기저기 위치 가능, 다음 노드의 주소를 가지고 있기때문에)
 */
public class LinkedListConception {
    public static void main(String[] args){
        List<String> arrayList = new ArrayList<>();
        System.out.println(System.identityHashCode(arrayList));
//        arrayList.add(1,"TEST"); // 빈 엘리먼트를 허락하지 않기때문에 0 부터 넣어주여야 한다.
//        System.out.println(System.identityHashCode(arrayList.get(1)));
        arrayList.add("1");
        arrayList.add("2");
        System.out.println(System.identityHashCode(arrayList.get(0)));
        System.out.println(arrayList.get(0).intern());
        // intern : String 객체로 생성된 것을 참조하는것이 아니라 String Pool에 저장된 것을 불러오고
        //          없는 경우 String pool에 생성. GC 대상에서 제외되도록? 한다? GC와 constants pool을 조금 더 살펴봐야함.
        System.out.println(arrayList);

        List<String> linkedList = new LinkedList<>();
        System.out.println(System.identityHashCode(arrayList));
        linkedList.add("0");
    }
}
