package org.example._2工厂;

/**
 * 工厂模式
 */
public class code {
    public static void main(String[] args) {
        Car car = CarFactory.getCar("五菱");
        Car car1 = CarFactory.getCar("特斯拉");
        car.name();
        car1.name();
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
                return null;
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
