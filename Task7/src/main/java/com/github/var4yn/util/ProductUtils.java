package com.github.var4yn.util;

/**
 * Вспомогательный класс, инкапсулирующий название товара, его количество и имя продавца этого товара
 */
public class ProductUtils {
    public final int count;
    public final String firstName, lastName, productName;

    /**
     * Конструктор
     * @param productName название товара
     * @param count количество товара
     * @param firstName имя продавца товара
     * @param lastName фамилия продавца товара
     */
    public ProductUtils(String productName, int count, String firstName, String lastName) {
        this.productName = productName;
        this.count = count;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ProductUtils{" +
                "count=" + count +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
