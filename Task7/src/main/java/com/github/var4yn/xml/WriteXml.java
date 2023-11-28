package com.github.var4yn.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Инкапсулирует обобщенный метод записи в файл в формате XML
 */
class WriteXml {
    private static final String TAG_ROOT = "elements";

    /**
     * Обобщенный метод записи Java-объектов в файл в формате XML
     * @param elements элементы, которые запишутся в файл
     * @param convert метод, преобразующий Java-объект к типу org.w3c.dom.Element
     * @param path путь к файлу вывода
     * @param <T> тип преобразуемых объектов
     * @throws ParserConfigurationException выбрасывает при парсинге в XML формат
     * @throws TransformerException выбрасывается при парсинге в XML формат
     */
    public static <T> void write(List<T> elements, ModelToXml<T> convert, String path) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement(TAG_ROOT);
        document.appendChild(rootElement);

        for(var item : elements) {
            rootElement.appendChild(convert.get(item, document));
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(document);

        try(var out = new OutputStreamWriter(new FileOutputStream(path))) {
            transformer.transform(domSource, new StreamResult(out));
        } catch (IOException e) {
            System.out.println("Ошибка при попытке записать данные в файл: " + e.getMessage());
        }
    }

}
