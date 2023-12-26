package org.example._7观察者;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */
public class code {
    public static void main(String[] args) {
        Subject subject = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);
        subject.setState(10);
        subject.setState(20);
    }
}

class Subject {
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
        notifyAllObserver();
    }

    private List<Observer> observerList = new ArrayList<>();

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void notifyAllObserver() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}

abstract class Observer {
    protected Subject subject;

    public Observer() {
    }

    public Observer(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public abstract void update();
}

class BinaryObserver extends Observer {
    public BinaryObserver() {
    }

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("二进制：" + Integer.toBinaryString(subject.getState()));
    }
}

class OctalObserver extends Observer {
    public OctalObserver() {
    }

    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("八进制：" + Integer.toOctalString(subject.getState()));
    }
}

