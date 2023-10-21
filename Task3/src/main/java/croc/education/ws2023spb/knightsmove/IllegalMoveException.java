package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если при перемещении шахматного коня из текущей клетки в следующую происходит с
 * нарушением правил.
 * 
 * @author Dmitry Malenok
 */
public class IllegalMoveException extends Exception {
    /**
     * Конструктор
     * @param firstPosition текущая позиция коня
     * @param secondPosition позиция, на которую конь не может совершить ход
     */
    public IllegalMoveException(ChessPosition firstPosition, ChessPosition secondPosition) {
        super(String.format("конь так не ходит: %s -> %s", firstPosition.toString(), secondPosition.toString()));
    }
}
