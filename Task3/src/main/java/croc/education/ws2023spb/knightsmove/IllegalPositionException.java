package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если текущая позиция нарушает правил
 *
 */
public class IllegalPositionException extends RuntimeException {
    /**
     * Конструктор
     * @param message дополнительное сообщение об исключении
     */
    public IllegalPositionException(final String message) {
        super("Позиция нарушает правила шахматной нотации: " + message);
    }

}
