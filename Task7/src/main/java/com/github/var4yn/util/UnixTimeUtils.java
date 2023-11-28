package com.github.var4yn.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Вспомогательный класс для преобразования Unix времени в дату
 */
class UnixTimeUtils {

    /**
     * Иркутское время
     */
    private static final ZoneId zoneId = ZoneId.of("UTC+8");

    /**
     * Преобразует Unix время в дату
     * @param unixTime Unix время
     * @return дата в строковом формате
     */
    public static String unixToString(long unixTime) {
        Instant instant = Instant.ofEpochMilli(unixTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDateTime.ofInstant(instant, zoneId).format(dateTimeFormatter);
    }
}
