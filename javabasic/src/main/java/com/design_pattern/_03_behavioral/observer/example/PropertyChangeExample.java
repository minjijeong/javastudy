package com.design_pattern._03_behavioral.observer.example;

import com.design_pattern._03_behavioral.observer.Subscriber;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PropertyChangeExample {
    static class User implements PropertyChangeListener{
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            System.out.println(evt.getPropertyName());
            System.out.println(evt.getNewValue());
        }
    }

    static class Subject{
        PropertyChangeSupport support = new PropertyChangeSupport(this);

        // 등록할때 이벤트 property 줄수 있음
        public void addObserver(PropertyChangeListener observer){
            support.addPropertyChangeListener(observer);
        }

        public void removeObserver(PropertyChangeListener observer){
            support.removePropertyChangeListener(observer);
        }

        // firePropertyIndexed 이런걸로 했을때, 우선순위 지정할 수 있다.
        public void add(String message){
            support.firePropertyChange("eventName", null, message);
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        User observer = new User();
        subject.addObserver(observer);
        subject.add("자바 PCL 예제 코드");
        subject.removeObserver(observer);
        subject.add("이 메세지는 볼수 없지.");
    }
}
