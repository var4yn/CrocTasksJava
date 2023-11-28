package com.github.var4yn.parse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Парсит JSON-объект в модель Java-класс
 */
class ParseModel {
    /**
     * Обобщенный метод, который парсит файл в тип JSONArray, затем преобразует элементы JSONArray к требуему типу
     * @param convert метод преобразующий JSONObject к требуемому типу
     * @param path путь к файлу, откуда парсятся JSON-объекты
     * @return Список моделей
     * @param <T> тип модели
     */
    public static <T> List<T> parse(CreateModel<T> convert, String path) {
        List<T> modelList = new ArrayList<>();
        try(FileReader fileReader = new FileReader(path)) {
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);

            for(Object it : jsonArray) {
                var item = (JSONObject) it;
                modelList.add(convert.get(item));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл для парсинга: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Ошибка при парсинге модели: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return modelList;
    }

}
