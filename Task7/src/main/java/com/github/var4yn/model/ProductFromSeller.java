package com.github.var4yn.model;

/**
 * Количество товаров у продавца
 */
public class ProductFromSeller {
    private final int sellerId, productId;
    private final int price, count;

    /**
     * Конструктор класса
     * @param sellerId - id продавца
     * @param productId - id товара
     * @param price - цена товара
     * @param count - количество товара у продавца
     */
    public ProductFromSeller(int sellerId, int productId, int price, int count) {
        this.sellerId = sellerId;
        this.productId = productId;
        this.price = price;
        this.count = count;
    }

    public int getSellerId() {
        return sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "ProductFromSeller{" +
                "sellerId=" + sellerId +
                ", productId=" + productId +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
