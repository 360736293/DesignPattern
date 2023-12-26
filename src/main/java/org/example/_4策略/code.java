package org.example._4策略;

/**
 * 策略模式
 */
public class code {
    public static void main(String[] args) {
        Context context = new Context(new Add());
        int result = context.executeStrategy(1, 2);
        System.out.println(result);
    }
}

class Context {
    private Strategy strategy;

    public Context() {
    }

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

interface Strategy {
    int doOperation(int num1, int num2);
}

class Add implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class Sub implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class Mul implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class Div implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 / num2;
    }
}


