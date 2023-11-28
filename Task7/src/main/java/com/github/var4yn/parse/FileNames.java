package com.github.var4yn.parse;

/**
 * Перечисление, которое хранит имена файлов
 */
enum FileNames {
    PRODUCT("product.json"), SALE("sale.json"), SELLER("seller.json"),
    PRODUCTFROMSELLER("productFromSeller.json");
    FileNames(final String fileName) {
        this.fileName = fileName;
    }
    public final String fileName;
}
