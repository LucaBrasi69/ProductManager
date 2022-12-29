package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    Product product = new Book(3, "Тестирование черного ящика", 1000, "Борис Бейзер");

    @Test
    public void shouldUseEquals() {
        Product third = new Product(3, "Тестирование черного ящика", 1000);
        Product fourth = new Product(3, "Тестирование черного ящика", 1000);
        assertEquals(third, fourth);

    }

    @Test
    public void shouldGetNameAndSetName() {
        String expected = "Тестирование черного ящика";
        product.getName();
        product.setName(expected);
        assertEquals(expected, product.getName());
    }

    @Test
    public void shouldGetIDAndSetId() {
        product.setId(3);
        assertEquals(3, product.getId());
    }

    @Test
    public void shouldSetPrice() {
        product.setPrice(1000);
        product.getPrice(1000);
        assertEquals(1000, 1000);

    }
}