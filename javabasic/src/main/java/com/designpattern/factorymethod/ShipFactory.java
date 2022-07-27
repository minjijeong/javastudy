package com.designpattern.factorymethod;

public class ShipFactory {
    
    static final String BLACKSHIP = "blackship";
    static final String WHILESHIP = "whiteship";

    public static Ship orderShip(String name, String email) {
        // validate
        if(name.isEmpty()){
            throw new IllegalArgumentException("배 이름을 지어주세요");
        }
        if(email.isEmpty()){
            throw new IllegalArgumentException("연락처를 남겨주세요.");
        }

        prepareFor(name);

        Ship ship = new Ship();
        ship.setName(name);

        // Customizing for specific name
        if(name.equalsIgnoreCase(WHILESHIP)){
            ship.setLogo("\uD83D\uDEE5");
        } else if (name.equalsIgnoreCase(BLACKSHIP)) {
            ship.setLogo("블랙쉽로고");
        }
        
        // Coloring 
        if(name.equalsIgnoreCase(BLACKSHIP)){
            ship.setColor("black");
        } else if (name.equalsIgnoreCase(WHILESHIP)) {
            ship.setColor("while");
        }

        sendEmailTo(email, ship);
        return ship;
    }

    private static void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.name + " 다 만들었습니다.");
    }

    private static void prepareFor(String name) {
        System.out.println(name + " 만들 준비 중");
    }
}
