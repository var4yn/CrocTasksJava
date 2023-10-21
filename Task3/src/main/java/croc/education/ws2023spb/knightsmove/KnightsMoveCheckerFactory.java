package croc.education.ws2023spb.knightsmove;

/**
 * Класс, реализующий фабричный метод, возвращающий обработчики, проверяющие, что последовательность клеток на шахматной
 * доске может быть пройдена ходом коня.
 *
 * @author Dmitry Malenok
 */
public final class KnightsMoveCheckerFactory {

    /**
     * Конструктор.
     */
    private KnightsMoveCheckerFactory() {
        // Конструктор задан только для того, чтобы экземпляр класса случайно не создали.
    }

    /**
     * Возвращает обработчик, проверяющий, что последовательность клеток на шахматной доске может быть пройдена ходом
     * коня.
     *
     * @return обработчик, проверяющий, что последовательность клеток на шахматной доске может быть пройдена ходом коня
     */
    public static KnightsMoveChecker get() {
        return positions -> {
            for(int i = 1; i < positions.length; i++) {
                // текущая позиция
                var currentPosition = ChessPositionParser.parse(positions[i]);
                // предыдущая позиция
                var lastPosition = ChessPositionParser.parse(positions[i-1]);

                // смещение по горизонтали
                int dx = Math.abs(currentPosition.x() - lastPosition.x());
                // смещение по вертикали
                int dy = Math.abs(currentPosition.y() - lastPosition.y());

                // (dx == 2 && dy == 1) || (dy == 2 && dx == 1) -> допустимый ход коня
                // ниже инверсия этого 👆 условия для бросания исключения на недопустимый ход коня
                if( (dx != 2 || dy != 1) && (dy != 2 || dx != 1) ) throw new IllegalMoveException(lastPosition, currentPosition);
            }
        };


    }

}
