package croc.education.ws2023spb.knightsmove;

/**
 * Класс, содержащий методы преобразования в объект расположения фигуры на шахматной доске из различных форматов.
 * 
 * @author Dmitry Malenok
 * @see ChessPosition
 */
public final class ChessPositionParser {

    /**
     * Конструктор.
     */
    private ChessPositionParser() {
        // Конструктор задан только для того, чтобы экземпляр класса случайно не создали.
    }

    /**
     * Разбирает наименование клетки шахматной доски, на которой находится фигура, в
     * <a href="https://w.wiki/7pFN">шахматной нотации</a> и возвращает соответствующий ей объект расположения фигуры на
     * шахматной доске.
     * 
     * @param position
     *            наименование клетки шахматной доски, на которой находится фигура
     * @return объект расположения фигуры на шахматной доске, соответствующий переданному наименованию клетки
     */
    public static ChessPosition parse(final String position) throws IllegalPositionException {
        if(position.length() != 2) throw new IllegalPositionException("позиция должна состоять из 2 символов");
        final char x = position.toLowerCase().charAt(0);
        final char y = position.charAt(1);

        // проверка на следование формату
        if(!checkFormat(x, y)) throw new IllegalPositionException("недопустимый формат позиции");
        // проверка на выход за границы шахматного поля
        if(!checkPosition(x, y)) throw new IllegalPositionException("выход за границы шахматной доски");

        return new ChessPosition() {
            @Override
            public int x() {
                return x-'a';
            }

            @Override
            public int y() {
                return y-'1';
            }

            @Override
            public String toString() {
                return String.format("%s%s", x, y);
            }
        };
    }

    /**
     * Проверка на соответствие формату строки
     * @param x позиция по горизонтали a-h
     * @param y позиция по вертикали 1-8
     * @return true если строка соответствует формату, иначе false
     */
    private static boolean checkFormat(final char x, final char y) {

        // если первый символ не из a-z, A-Z, то false
        if(!Character.isAlphabetic(x)) return false;
        // если второй символ не 0-9, то false
        if(!Character.isDigit(y)) return false;

        return true;
    }

    /**
     * Проверить на выход за границу доски
     * @param x позиция по горизонтали a-h
     * @param y позиция по вертикали 1-8
     * @return true если позиция находится внутри шахматного поля, иначе false
     */
    private static boolean checkPosition(final char x, final char y) {
        if( x - 'a' < 0 || x - 'a' > 7) return false;
        if( y - '1' < 0 || y - '1' > 7) return false;

        return true;
    }
}
