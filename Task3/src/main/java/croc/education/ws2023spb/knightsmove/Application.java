package croc.education.ws2023spb.knightsmove;

/**
 * Приложение, проверяющее возможность прохождения последовательности клеток на шахматной доске ходом коня.
 */
public final class Application {

    /**
     * Основной метод приложения.
     *
     * @param args
     *            аргументы
     */
    public static void main(final String[] args) {
        var checker = KnightsMoveCheckerFactory.get();
        try {
            checker.check(args);
            System.out.print("OK");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
