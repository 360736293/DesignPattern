package org.example._6建造者;

/**
 * 建造者模式
 */
public class Code {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.buildA("地基").buildB("墙体").buildC("窗户").buildD("屋顶");
        Product product = worker.getProduct();
        System.out.println(product.toString());
    }
}

class Product {
    private String buildA;
    private String buildB;
    private String buildC;
    private String buildD;

    public String getBuildA() {
        return buildA;
    }

    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }

    public String getBuildB() {
        return buildB;
    }

    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }

    public String getBuildC() {
        return buildC;
    }

    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }

    public String getBuildD() {
        return buildD;
    }

    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }

    @Override
    public String toString() {
        return "Product{" +
                "buildA='" + buildA + '\'' +
                ", buildB='" + buildB + '\'' +
                ", buildC='" + buildC + '\'' +
                ", buildD='" + buildD + '\'' +
                '}';
    }
}

interface Builder {
    Worker buildA(String msg);

    Worker buildB(String msg);

    Worker buildC(String msg);

    Worker buildD(String msg);

    Product getProduct();
}

class Worker implements Builder {
    private Product product;

    public Worker() {
        product = new Product();
    }

    @Override
    public Worker buildA(String msg) {
        product.setBuildA(msg);
        return this;
    }

    @Override
    public Worker buildB(String msg) {
        product.setBuildB(msg);
        return this;
    }

    @Override
    public Worker buildC(String msg) {
        product.setBuildC(msg);
        return this;
    }

    @Override
    public Worker buildD(String msg) {
        product.setBuildD(msg);
        return this;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}



