package com.github.var4yn.parse;

import org.json.simple.JSONObject;

/**
 * Функциональный интерфейс. Получает JSONObject, преобразует его в требуемый тип модели и возращает Java-класс
 * @param <T> - тип модели, к которой приводится JSONObject
 */
@FunctionalInterface
interface CreateModel<T> {
    T get(JSONObject value);
}
