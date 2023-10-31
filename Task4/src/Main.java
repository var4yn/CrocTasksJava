import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс выводит в файл output.txt количество вхождений каждого символа из файла input.txt
 * Результат отсортирован по кол-ву вхождений каждого символа
 *
 */
public class Main {

    /**
     * Путь до файла ввода
     */
    private static final String input_path = "input.txt";

    /**
     * Путь до файла вывода
     */
    private static final String output_path = "output.txt";


    /**
     * Метод, который подсчитывает кол-во вхождений каждого символа в файле <i>input.txt</i> с кодировкой UTF-8.
     * Результат сортируется по кол-ву вхождений и записывается в файле <i>output.txt</i> с кодировкой UTF-8.
     */
    public static void main(String[] args) {

        // Для подсчета вхождений определенных символов используется HashMap
        Map<Character, Integer> charIntegerMap = new HashMap<>();

        // чтение с файла
        try(var in = new InputStreamReader(new FileInputStream(input_path), StandardCharsets.UTF_8)) {
            int c;
            // читаем файл, пока он не закончился
            while( (c = in.read()) != -1 ) {
                // игнорируются пробелы, перевод строки и отступы
                if(c == ' ' || c == '\n' || c == '\t' || c == '\r' || c == '\f') continue;
                // подсчет кол-ва вхождений символа
                charIntegerMap.merge((char) c, 1, Integer::sum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // для сортировки по значению выполним сортировку ключей относительно их значений.
        // в ArrayList сохраняются ключи
        ArrayList<Character> keysList = new ArrayList<>(charIntegerMap.keySet());
        // ключи сортируются по значению, которое берется из Map<K,V>
        keysList.sort(Comparator.comparingInt(charIntegerMap::get).reversed());

        // запись результатов в файл
        try(var out = new OutputStreamWriter(new FileOutputStream(output_path), StandardCharsets.UTF_8)) {

            for(Character key : keysList) {
                out.write(String.format("%s = %d%n", key, charIntegerMap.get(key)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
