package com.github.var4yn.model;

/**
 * Товар
 */
public class Product {
    private final String name;
    private final int id;

    /**
     * Конструктор класса
     * @param id - id товара
     * @param name - название товара
     */
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
