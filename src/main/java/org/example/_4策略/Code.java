package org.example._4策略;

/**
 * 策略模式
 */
public class Code {
    public static void main(String[] args) {
        double add = new Context(new Add()).executeStrategy(1d, 2d);
        System.out.println(add);
        double sub = new Context(new Sub()).executeStrategy(1d, 2d);
        System.out.println(sub);
        double mul = new Context(new Mul()).executeStrategy(1d, 2d);
        System.out.println(mul);
        double div = new Context(new Div()).executeStrategy(1d, 2d);
        System.out.println(div);
    }
}

class Context {
    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double num1, double num2) {
        return strategy.doOperation(num1, num2);
    }
}

interface Strategy {
    double doOperation(double num1, double num2);
}

class Add implements Strategy {
    @Override
    public double doOperation(double num1, double num2) {
        return num1 + num2;
    }
}

class Sub implements Strategy {
    @Override
    public double doOperation(double num1, double num2) {
        return num1 - num2;
    }
}

class Mul implements Strategy {
    @Override
    public double doOperation(double num1, double num2) {
        return num1 * num2;
    }
}

class Div implements Strategy {
    @Override
    public double doOperation(double num1, double num2) {
        return num1 / num2;
    }
}


