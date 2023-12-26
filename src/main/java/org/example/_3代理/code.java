package org.example._3代理;

/**
 * 代理模式
 */
public class code {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Host());
        proxy.rent();
    }
}

interface Rent {
    void rent();
}

class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}

class Proxy implements Rent {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        fare();
    }

    public void seeHouse() {
        System.out.println("中介带你看房");
    }

    public void fare() {
        System.out.println("收中介费");
    }
}