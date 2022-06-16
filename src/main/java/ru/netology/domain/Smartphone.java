package ru.netology.domain;

public class Smartphone extends Product {
    private String developer;


    public Smartphone(int id, String name, int cost) {
        super(id, name, cost);
    }

    public Smartphone(int id, String name, String developer, int cost) {
        super(id, name, cost);
        this.developer = developer;
    }

    public String getDeveloper() {
        return developer;
    }
}
