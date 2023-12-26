package org.example._1单例._2懒汉式;

/**
 * 懒汉式单例模式
 */
public class code {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
    }
}

class Singleton {
    // 1.私有化构造器，防止外部通过new创建实例
    private Singleton() {

    }

    // 2.创建一个私有的静态实例
    private static Singleton instance;

    // 3.创建一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
