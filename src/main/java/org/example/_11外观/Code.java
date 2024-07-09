package org.example._11外观;

/**
 * 外观模式（又叫门面模式）
 */
public class Code {
    public static void main(String[] args) {
        Facade fd = new Facade();

        fd.doSomethingA();
        fd.doSomethingB();
        fd.doSomrthingC();
    }
}

class ClassA {

    public void doSomethingA() {
        System.out.println("do something a");
    }
}

class ClassB {

    public void doSomethingB() {
        System.out.println("do something b");
    }
}

class ClassC {

    public void doSomethingC() {
        System.out.println("do something c");
    }
}

class Facade {

    //被委托对象
    private ClassA ca;
    private ClassB cb;
    private ClassC cc;

    public Facade() {
        this.ca = new ClassA();
        this.cb = new ClassB();
        this.cc = new ClassC();
    }

    //提供给外部的访问方法
    public void doSomethingA() {
        this.ca.doSomethingA();
    }

    public void doSomethingB() {
        this.cb.doSomethingB();
    }

    public void doSomrthingC() {
        this.cc.doSomethingC();
    }
}