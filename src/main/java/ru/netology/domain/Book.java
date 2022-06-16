package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book(int id, String name, String author, int cost) {
        super(id, name, cost);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

