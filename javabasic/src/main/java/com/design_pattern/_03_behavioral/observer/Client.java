package com.design_pattern._03_behavioral.observer;

public class Client {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User user1 = new User("keesun");
        User user2 = new User("whiteship");

        chatServer.register("디자인패턴", user1);
        chatServer.register("디자인패턴", user2);
        chatServer.register("오징어게임", user1);

        chatServer.sendMessage(user1, "디자인패턴", "예제 코드 보는 중...");
        chatServer.sendMessage(user1,"오징어게임", "오징어 게임 그렇게 재밌나...?");
    }
}
