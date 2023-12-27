package org.example._9适配器;

/**
 * 适配器模式
 */
public class code {
    public static void main(String[] args) {
        TargetFather target = new Adapter();
        target.firstAct();
    }
}

interface TargetFather {
    void firstAct();
}

interface AdapteeFather {
    void secondAct();
}

class Adaptee implements AdapteeFather {
    @Override
    public void secondAct() {
        System.out.println("secondAct");
    }
}

class Adapter implements TargetFather {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void firstAct() {
        System.out.println("firstAct");
        adaptee.secondAct();
    }
}
