package com.github.var4yn.xml;

import com.github.var4yn.util.DateProductUtils;
import com.github.var4yn.util.ProductUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.List;

/**
 * Прикладные реализации записи данных в XML формате
 */
public class XmlWriter {

    /**
     * Путь к папке вывода
     */
    private static final String PATH = "./src/main/resources/output/";
    private static final String TAG_ELEMENT = "element";

    /**
     * Реализация метода для записи ProductUtils в файл в формате XML
     * @param productUtilsList список ProductUtils, инкапсулирующий (название товара - количество товара - имя продавца)
     */
    public static void WriteProductUtils(List<ProductUtils> productUtilsList) {
        try {
            WriteXml.write(productUtilsList, (ProductUtils item, Document document) -> {
                Element documentElement = document.createElement(TAG_ELEMENT);
                documentElement.setAttribute("count", String.valueOf(item.count));
                documentElement.setAttribute("firstNameSeller", item.firstName);
                documentElement.setAttribute("lastNameSeller", item.lastName);
                documentElement.setTextContent(item.productName);
                return documentElement;
            }, PATH + "task1.xml");
        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Ошибка при попытке сохранить данные в XML формате: " + e.getMessage());
        }
    }

    /**
     * Реализация метода для записи DateProductUtils в файл в формате XML
     * @param dateProductUtilsList список DateProductUtils, инкапсулирующий (дата - количество продаж)
     */
    public static void WriteDateProductUtils(List<DateProductUtils> dateProductUtilsList) {
        try {
            WriteXml.write(dateProductUtilsList, (DateProductUtils item, Document document) -> {
                Element documentElement = document.createElement(TAG_ELEMENT);
                documentElement.setAttribute("date", item.date);
                documentElement.setTextContent(String.valueOf(item.totalCount));
                return documentElement;
            }, PATH + "task2.xml");
        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Ошибка при попытке сохранить данные в XML формате: " + e.getMessage());
        }
    }

}
