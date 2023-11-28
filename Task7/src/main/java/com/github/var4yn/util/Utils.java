package com.github.var4yn.util;

import com.github.var4yn.model.Product;
import com.github.var4yn.model.ProductFromSeller;
import com.github.var4yn.model.Sale;
import com.github.var4yn.model.Seller;
import com.github.var4yn.parse.Parser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Прикладной класс
 */
public class Utils {

    /**
     * Задание 1.
     * Для каждого товара определить продавца, у которого максимальное количество этого товара.
     *
     * @return возвращает список из вспомогательного класса,
     *         инкапсулирующего название товара, максимальное количество товара и продавца, у которого это кол-во товара.
     */
    public static List<ProductUtils> MaxCountOfProduct() {
        // Вспомогательный вложенный класс
        class Pair<K, V> {
            public final K first;
            public final V second;
            Pair(K key, V value) {
                this.first = key;
                this.second = value;
            }
        }

        // 1. Получить список товаров
        List<Product> productList = Parser.parseProducts();
        // 2. Получить список кол-ва товара у продавца
        List<ProductFromSeller> productFromSellerList = Parser.parseProductFromSeller();
        // 3. Получить список продавцов
        List<Seller> sellerList = Parser.parseSeller();

        // Поставить в соответствие ID продавца с его именем
        HashMap<Integer, Pair<String, String>> sellerFirstNameAndLastName = new HashMap<>();
        for(var seller : sellerList) {
            sellerFirstNameAndLastName.put(seller.getId(), new Pair<>(seller.getFirstName(), seller.getLastName()));
        }


        /* Map хранит productId,
           которому соответствует маскимальное количество товара
           и продавец, который владеет этим товаром.
        */
        // пара хранит <количество товара, ID продавца>
        HashMap<Integer, Pair<Integer, Integer>> productIdCountSellerIdMap = new HashMap<>();


        for(var item : productFromSellerList) {
            // Проверка, что ключ ссылаемый на продавца действительный
            if(!sellerFirstNameAndLastName.containsKey(item.getSellerId())) continue;

            // установка значений по умолчанию
            if(!productIdCountSellerIdMap.containsKey(item.getProductId())) {
                productIdCountSellerIdMap.put(item.getProductId(), new Pair<>(item.getCount(), item.getSellerId()));
                continue;
            }

            // получить пару <количество товара, ID продавца>
            Pair<Integer, Integer> pair = productIdCountSellerIdMap.get(item.getProductId());
            // если текущее количество товара оказалось больше, чем хранимое в HashMap -> обновить значения
            if(item.getCount() > pair.first) {
                productIdCountSellerIdMap.put(item.getProductId(), new Pair<>(item.getCount(), item.getSellerId()));
            }
        }

        List<ProductUtils> productUtilsList = new ArrayList<>();
        for(var product : productList) {
            if(productIdCountSellerIdMap.containsKey(product.getId())) {
                var item = productIdCountSellerIdMap.get(product.getId());

                Pair<String, String> fullName = sellerFirstNameAndLastName.get(item.second);
                productUtilsList.add(new ProductUtils(product.getName(), item.first, fullName.first, fullName.second));
            }
        }

        return productUtilsList;
    }

    /**
     * Задание 2.
     * Распределение общего количества продаж по датам
     * @return Возвращает вспомогательный класс, инкапсулирующий дату продажи и общее количество проданного товара в этот день
     */
    public static List<DateProductUtils> DateOfSaleCount() {
        // 1. Получить список продаж
        List<Sale> saleList = Parser.parseSale();

        // отсортировать по полю типа long - дата продажи
        saleList.sort(Comparator.comparingLong(Sale::getDateOfSale));

        // для сохранения порядка, после сортировки используется LinkedHashMap
        LinkedHashMap<String, Integer> dateStringCountIntegerMap = new LinkedHashMap<>();

        for(var sale : saleList) {
            String date = UnixTimeUtils.unixToString(sale.getDateOfSale());
            var value = 0;
            if(dateStringCountIntegerMap.containsKey(date)) {
                value = dateStringCountIntegerMap.get(date);
            }
            dateStringCountIntegerMap.put(date, sale.getNumberOfItemSold() + value);
        }

        List<DateProductUtils> dateProductUtilsList = new ArrayList<>();
        for(var i : dateStringCountIntegerMap.entrySet()) {
            dateProductUtilsList.add(new DateProductUtils(i.getKey(), i.getValue()));
        }

        return dateProductUtilsList;
    }
}
