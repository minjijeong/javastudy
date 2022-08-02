package com.design_pattern._03_behavioral.observer.example;

import com.design_pattern._03_behavioral.observer.Subscriber;
import java.util.Observable;
import java.util.Observer;

public class ObserverInJava {
    static class User implements Observer {// Java9 사용 권장하지 않음
        @Override
        public void update(Observable o, Object arg) {
            System.out.println(arg);
        }
    }

    static class Subject extends Observable{
        // Java9 사용 권장하지 않음
        // - JavaBeans 패키지- PropertyChangeListener, , Java
        public void add(String message){
            setChanged(); // 상태가 변경 되어지야만 notifyObserver 실행가능, 여러번 notify 안됨
            notifyObservers(message);
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        User user = new User();
        subject.addObserver(user);
        subject.add("Hello Java, Observer");
    }
}
