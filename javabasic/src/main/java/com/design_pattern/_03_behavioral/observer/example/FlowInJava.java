package com.design_pattern._03_behavioral.observer.example;

import java.util.concurrent.*;

/**
 * Flow
 * - Publisher
 * - Subscriber
 * - Subscription
 * - Processor = Publisher + Subscriber
 */
public class FlowInJava {
//    public static void main(String[] args) {
//        /**
//         * 동기적 publish
//         */
//        Flow.Publisher<String> publisher = new Flow.Publisher<String>(){
//            @Override
//            public void subscribe(Flow.Subscriber<? super String> subscriber){
//                subscriber.onNext("hello flow"); // 메세지 전송
//                subscriber.onComplate();
//            }
//        };
//        /**
//         * 비동기적 publishing
//         */
////        Flow.Publisher<String> publisher = new SubmissionPublisher<>();
//
//        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>(){
//            @Override
//            public void onSubscribe(Flow.Subscription subscription){
//            }
//
//            @Override
//            public void onNext(String item){
//                System.out.println(item);
//            }
//
//            @Override
//            public void onError(Throwable throwable){
//            }
//
//            @Override
//            public void onComplate(){
//                System.out.println("complated");
//            }
//        };
//        publisher.subscribe(subscriber);
//    }
}
