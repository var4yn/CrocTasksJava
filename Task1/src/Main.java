/**
 * Детектор палиндрома
 */
public class Main {
    /**
     * Демонстрация работы метода isPalindrome
     */
    public static void main(String[] args) {
        // Тестовые данные
        String[] palindromes = {
                "abacaba",
                "abba",
                "А роза упала на лапу Азора",
                "aba",
                "b",
        };
        String[] others = {
                "ab",
                "codeforces",
        };

        // проверка на палиндромах
        printTests(palindromes);
        // проверка не на палиндромах
        printTests(others);

    }

    /**
     * Применяет метод isPalindrome на тестовых данных и выводит результат
     * @param tests - тестовые данные для метода isPalindrome
     */
    private static void printTests(String[] tests) {
        for(var test : tests) {
            System.out.printf("%s - %b\n", test, isPalindrome(test));
        }
        System.out.println();
    }


    /**
     * Проверят является ли строка палиндромом
     * @param string - строка, которую требуется проверить
     * @return true - если строка является палиндромом, иначе false
     */
    public static boolean isPalindrome(String string) {
        // удаляем пунктуаторы и пробелы из строки
        // \\p{Punct} - регулярное выражение пунктуаторов
        string = string.replaceAll("[\\p{Punct}\s]+", "").toLowerCase();
        int n = string.length(); // Сохраняем длину строки


        for(int i = 0; i < n/2; i++) {
            // одновременно читаем символы справа-налево и слева-направо
            // если в какой-то момент символы неравны, то строка - не палиндром
            if(string.charAt(i) != string.charAt(n-i-1)) {
                return false;
            }
        }

        return true;
    }
}
