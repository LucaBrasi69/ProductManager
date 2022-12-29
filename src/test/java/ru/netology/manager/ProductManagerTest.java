package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "One", 100, "AOne");
    Product product2 = new Book(2, "Second", 200, "ASecond");
    Product product3 = new Book(3, "Third", 300, "AThird");
    Product product4 = new Book(4, "Fourth", 400, "AFourth");
    Product product5 = new Book(5, "Fifth", 500, "AFifth");
    Product product6 = new Smartphone(6, "Sixth", 600, "MSixth");
    Product product7 = new Smartphone(7, "Seventh", 700, "MSeventh");
    Product product8 = new Smartphone(8, "Eighth", 800, "MEighth");
    Product product9 = new Smartphone(9, "Ninth", 900, "MNinth");
    Product product10 = new Smartphone(10, "Tenth", 1000, "MTenth");

    @BeforeEach
    void setUp() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
        manager.add(product9);
        manager.add(product10);

    }

    @Test
    void searchByBookMaker() {
        Product[] actual = manager.searchBy("AOne");
        Product[] expected = {new Book(1, "One", 100, "AOne")};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneManufacturer() {
        Product[] actual = manager.searchBy("MSixth");
        Product[] expected = {new Smartphone(6, "Sixth", 600, "MSixth")};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneName() {
        Product[] actual = manager.searchBy("Sixth");
        Product[] expected = {new Smartphone(6, "Sixth", 600, "MSixth")};
        assertArrayEquals(expected, actual);

    }

    @Test
    void searchByBookName() {
        Product[] actual = manager.searchBy("Second");
        Product[] expected = {new Book(2, "Second", 200, "ASecond")};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRemoveById() {
        repository.removeById(7);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{product1, product2, product3, product4, product5, product6, product8, product9, product10};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByInvalidManufacturer() {
        Product[] actual = manager.searchBy("MEleventh");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByInvalidAuthor() {
        Product[] actual = manager.searchBy("ASixth");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test // Тест сохранения всего списка
    void shouldGetAll() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[] {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(actual));
    }
}