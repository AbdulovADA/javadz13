package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    Book book1 = new Book(2, "1984", "George Orwell", 100);
    Book book2 = new Book(4, "It", "Stephen King", 300);
    Book book3 = new Book(6, "Dune", "Frank Gerbert", 500);
    Book book4 = new Book(8, "Under the Dome", "Stephen King", 700);
    Smartphone smartphone1 = new Smartphone(1, "iPhone 9", "USA", 999);
    Smartphone smartphone2 = new Smartphone(3, "YotaPhone", "Russia", 1);
    Smartphone smartphone3 = new Smartphone(5, "Samsung D22", "South Korea", 900);
    Smartphone smartphone4 = new Smartphone(7, "Samsung S21", "South Korea", 1000);
    ProductManager manager = new ProductManager();

    @Test
    void addProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3, smartphone4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("un");
        Product[] expected = {book3, smartphone3, smartphone4};

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBy1() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("9");
        Product[] expected = {book1, smartphone1};

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBy2() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy(" ");
        Product[] expected = {book4, smartphone1, smartphone3, smartphone4};

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBy3() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("D");
        Product[] expected = {book3, book4, smartphone3};

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBy4() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("100");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBy5() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("я");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getProduct() {
        Product data = new Product(100, "test", 500);
        assertEquals(100, data.getId());
        assertEquals("test", data.getName());
        assertEquals(500, data.getCost());
    }

    @Test
    void deleteById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        manager.removeById(7);
        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void deleteById2() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        assertThrows(NotFoundException.class, () -> {
            manager.removeById(10);
        });
    }

    @Test
    void deleteById3() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        assertThrows(NotFoundException.class, () -> {
            manager.removeById(-1);
        });
    }

    @Test
    void getSmartphone() {
        Smartphone data = new Smartphone(100, "test", "China", 500);
        assertEquals(100, data.getId());
        assertEquals("test", data.getName());
        assertEquals("China", data.getDeveloper());
        assertEquals(500, data.getCost());
    }

    @Test
    void getSmartphone1() {
        Smartphone data = new Smartphone(100, "test", 500);
        assertEquals(100, data.getId());
        assertEquals("test", data.getName());
        assertEquals(500, data.getCost());
    }

    @Test
    void Book() {
        Book data = new Book(100, "test", "tom", 600);
        assertEquals(100, data.getId());
        assertEquals("test", data.getName());
        assertEquals("tom", data.getAuthor());
        assertEquals(600, data.getCost());
    }

}
