package org.example._2工厂;

/**
 * 工厂模式
 */
public class Code {
    public static void main(String[] args) {
        Factory wuLingCarFactory = new WuLingCarFactory();
        wuLingCarFactory.getCar().name();
        Factory teslaCarFactory = new TeslaCarFactory();
        teslaCarFactory.getCar().name();
    }
}

interface Factory {
    Car getCar();
}

class WuLingCarFactory implements Factory {
    @Override
    public Car getCar() {
        return new WuLing();
    }
}

class TeslaCarFactory implements Factory {
    @Override
    public Car getCar() {
        return new Tesla();
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
