package org.example._10模板;

/**
 * 模板模式
 */
public class Code {
    public static void main(String[] args) {
        GameTemplate game = new Cricket();
        game.play();
        game = new Football();
        game.play();

    }
}

abstract class GameTemplate {

    /**
     * 子类只管实现具体的执行方法，不用管执行规则
     */
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    /**
     * 模板，这里是执行上面方法的规则。
     * 一般不能让子类随意更改，所以使用final进行修饰（不能用private，不然子类无法访问调用）。
     */
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends GameTemplate {

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}

class Football extends GameTemplate {

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}



