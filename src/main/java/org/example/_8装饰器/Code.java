package org.example._8装饰器;

/**
 * 装饰器模式
 */
public class Code {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink sugar = new Sugar(coffee);
        Drink milk = new Milk(sugar);
        System.out.println(milk.info() + " 总价格：" + milk.cost());
    }
}

abstract class Drink {
    private String name;
    private float price;

    public Drink() {
    }

    public Drink(String name) {
        this.name = name;
    }

    public Drink(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public float setPrice(float price) {
        return this.price = price;
    }

    public abstract float cost();

    public String info() {
        return name + " 价格：" + price;
    }
}

class Coffee extends Drink {
    public Coffee() {
        super("咖啡", 10.0f);
    }

    @Override
    public float cost() {
        return super.getPrice();
    }
}

class Milk extends Drink {
    private Drink drink;

    public Milk(Drink drink) {
        super("牛奶", 2.0f);
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost();
    }

    @Override
    public String info() {
        return super.info() + " " + drink.info();
    }
}

class Sugar extends Drink {
    private Drink drink;

    public Sugar(Drink drink) {
        super("糖", 1.0f);
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost();
    }

    @Override
    public String info() {
        return super.info() + " " + drink.info();
    }
}


