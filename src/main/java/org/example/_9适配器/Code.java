package org.example._9适配器;

/**
 * 适配器模式
 */
public class Code {
    public static void main(String[] args) {
        Circle circle = new CircleImpl();
        circle.calculateArea();
        Square square = new CircleAdapter(circle);
        square.calculateArea();
    }
}


interface Circle {
    public void calculateArea();
}

interface Square {
    public void calculateArea();
}

class CircleImpl implements Circle {

    @Override
    public void calculateArea() {
        System.out.println("计算圆的面积");
    }
}

class CircleAdapter implements Square {
    private Circle circle;

    public CircleAdapter(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void calculateArea() {
        circle.calculateArea();
    }
}