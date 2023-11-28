package com.github.var4yn.util;

/**
 * Вспомогательный класс, инкапсулирующий дату и общее количество продаж за этот день
 */
public class DateProductUtils {
    public final String date;
    public final int totalCount;

    /**
     * Конструктор класса
     * @param date дата продажи
     * @param totalCount общее количество проданного товара
     */
    public DateProductUtils(String date, int totalCount) {
        this.date = date;
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "DateProductUtils{" +
                "date='" + date + '\'' +
                ", totalCount=" + totalCount +
                '}';
    }
}
