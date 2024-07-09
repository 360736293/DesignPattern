package org.example._2工厂;

/**
 * 工厂模式
 */
public class Code {
    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("五菱");
        car1.name();
        Car car2 = CarFactory.getCar("特斯拉");
        car2.name();
        Car car3 = CarFactory.getCar("骷髅马");
        car3.name();
    }
}

class CarFactory {
    public static Car getCar(String carName) {
        switch (carName) {
            case "五菱":
                return new WuLing();
            case "特斯拉":
                return new Tesla();
            default:
                throw new RuntimeException("unknown car");
        }
    }
}

abstract class Car {
    abstract void name();
}

class WuLing extends Car {
    @Override
    public void name() {
        System.out.println("五菱宏光");
    }
}

class Tesla extends Car {
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
