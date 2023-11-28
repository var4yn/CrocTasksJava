package com.github.var4yn.parse;

import com.github.var4yn.model.Product;
import com.github.var4yn.model.ProductFromSeller;
import com.github.var4yn.model.Sale;
import com.github.var4yn.model.Seller;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Класс, реализующий обобщенный метод ParseModel.parse()
 */
public class Parser {
    /**
     * Путь к папке ввода
     */
    private final static String PATH = "./src/main/resources/input/";

    /**
     * Реализует обобщенный метод ParseModel.parse()
     * @return возвращает список товаров
     */
    public static List<Product> parseProducts() {
        return ParseModel.parse((JSONObject item) -> {
            long id = (Long) item.get("id");
            String name = (String) item.get("name");
            return new Product((int) id, name);
        }, PATH + FileNames.PRODUCT.fileName);
    }

    /**
     * Реализует обобщенный метод ParseModel.parse()
     * @return возвращает список продаж
     */
    public static List<Sale> parseSale() {
        return ParseModel.parse(item -> {
            long id = (Long) item.get("id");
            long sellerId = (Long) item.get("sellerId");
            long productId = (Long) item.get("productId");
            long number = (Long) item.get("number");
            long date = (Long) item.get("date");
            return new Sale((int) id, (int) productId, (int) sellerId, (int) number, date);
        }, PATH + FileNames.SALE.fileName);
    }

    /**
     * Реализует обобщенный метод ParseModel.parse()
     * @return возвращает список продавцов
     */
    public static List<Seller> parseSeller() {
        return ParseModel.parse(item -> {
            long id = (Long) item.get("id");
            String lastName = (String) item.get("lastName");
            String firstName = (String) item.get("firstName");
            return new Seller((int) id, lastName, firstName);
        }, PATH + FileNames.SELLER.fileName);
    }

    /**
     * Реализует обобщенный метод ParseModel.parse()
     * @return возвращает список товаров у продавцов
     */
    public static List<ProductFromSeller> parseProductFromSeller() {
        return ParseModel.parse(item -> {
            long sellerId = (Long) item.get("sellerId");
            long productId = (Long) item.get("productId");
            long price = (Long) item.get("price");
            long count = (Long) item.get("count");
            return new ProductFromSeller((int) sellerId, (int) productId, (int) price, (int) count);
        }, PATH + FileNames.PRODUCTFROMSELLER.fileName);
    }

}
