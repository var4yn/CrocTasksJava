package com.github.var4yn;


import com.github.var4yn.util.DateProductUtils;
import com.github.var4yn.util.ProductUtils;
import com.github.var4yn.util.Utils;
import com.github.var4yn.xml.XmlWriter;

import java.util.List;

/**
 * Точка входа в программу.
 *
 * Задание 1.
 * Для каждого товара вывести в файл продавца,
 * у которого в наличии наибольшее количество этого товара, и само количество этого товара у него в наличии.
 *
 *
 * Задание 2.
 * Вывести в файл распределение общего количества продаж по датам
 *
 *
 * Входные данные в виде файла в формате JSON
 * Выходные данные в виде файла в формате XML
 *
 * пакет util - прикладная реализация методов для решения прикладных задач
 * пакет model - модели данных
 * пакет xml - реализация класса для записи в файл в формате XML
 * пакет parse - парсинг JSON данных
 *
 */
public class Application {
    public static void main(String[] args) {

        // task 1
        // Получить список ProductUtils, инкапсулирующий название товара, кол-во товара и продавца
        List<ProductUtils> products = Utils.MaxCountOfProduct();
        // Вызов метода для сохранения данных в файл XML
        XmlWriter.WriteProductUtils(products);

        // task 2
        // Получить список DateProductUtils, инкапсулирующий дату и общее кол-во продаж в этот день
        List<DateProductUtils> dates = Utils.DateOfSaleCount();
        // Вызов метода для сохранения данных в файл XML
        XmlWriter.WriteDateProductUtils(dates);

        System.out.println("OK");

    }
}
