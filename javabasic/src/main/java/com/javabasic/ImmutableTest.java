package com.javabasic;

import java.util.ArrayList;
import java.util.List;

public class ImmutableTest{

    public static class Name{
        /**
         * private final로 선언하여 setter 메소드를 작동할 수 없도록 처리
         */
        private final String name;
        public Name(String name){
            this.name = name;
        }

//        public void setName(String name) {
//            this.name = name;
//        }

        @Override
        public String toString() {
            return "Name{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    public static class Names{
        /**
         * names를 final로 선언해도 그 하위 모든 객체를 immutable로 만들지 않으면 mutable 하게 작동한다.
         */
        private final List<Name> names;
        public Names(List<Name> names){
            this.names = new ArrayList<>(names);
        }

        @Override
        public String toString() {
            return "Names{" +
                    "names=" + names +
                    '}';
        }
    }

    public static void main(String[] args) {
        Name crew1 = new Name("Fafi");
        Name crew2 = new Name("Kevin");

        List<Name> originalNames = new ArrayList<>();
        originalNames.add(crew1);
        originalNames.add(crew2);

        Names crewNames = new Names(originalNames);
        System.out.println(originalNames);
        System.out.println(crewNames);
//        crew2.setName("Sally"); // [오류] setName 성립불가능하므로
        System.out.println(originalNames);
        System.out.println(crewNames);
    }
}
