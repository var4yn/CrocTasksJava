package com.github.var4yn.model;

/**
 * Продажа
 */
public class Sale {
    private final int productId, sellerId, id, numberOfItemSold;
    private final long dateOfSale;

    /**
     * Конструктор класса
     * @param id - id продажи
     * @param productId - id товара
     * @param sellerId - id продавца
     * @param numberOfItemSold - количество проданного товара
     * @param dateOfSale - дата продажи в Unix time
     */
    public Sale(int id, int productId, int sellerId, int numberOfItemSold, long dateOfSale) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.id = id;
        this.numberOfItemSold = numberOfItemSold;
        this.dateOfSale = dateOfSale;
    }


    public int getProductId() {
        return productId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfItemSold() {
        return numberOfItemSold;
    }

    public long getDateOfSale() {
        return dateOfSale;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "productId=" + productId +
                ", sellerId=" + sellerId +
                ", id=" + id +
                ", numberOfItemSold=" + numberOfItemSold +
                ", dateOfSale=" + dateOfSale +
                '}';
    }
}
