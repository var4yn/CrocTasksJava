import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * Стартовый класс.
 */
public class Main {

    /**
     * Точка старта приложения
     *
     * @param args
     *          стартовые аргументы
     */
    public static void main(String[] args){

        var matrix = MatrixExample.C;


        printResult("computeInThreads", matrix, () -> computeInThreads(matrix.getMatrix()));

        printResult("detOneThread", matrix, () -> detOneThread(matrix.getMatrix()));
    }

    /**
     * Вычисляет определитель матрицы через пул потоков ForkJoinPool.
     * @param matrix матрицы
     * @return определитель матрицы
     */
    private static long computeInThreads(long[][] matrix) {
        // Инкаспулирует создание пула потоков
        // используется ForkJoinPool для эффективной работы с рекурсивными задачами
        try (var executorService = new ForkJoinPool(); ) {
            return detManyThread(matrix, executorService);
        }
    }

    /**
     * Рекурсивный расчет определителя матрицы методом разложения по строке в несколько потоков.
     * @param a матрица
     * @param executorService executor для выполнения асинхронных задач
     * @return определитель матрицы
     */
    private static long detManyThread(long[][] a, ExecutorService executorService) {
        if (a.length == 1) {
            return a[0][0];
        }
        var result = 0L;

        // контейнер для хранения Future<T> объектов
        ArrayList<Future<Long>> futures = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            // текущий минор
            var cur = minor(a, i);
            // создание асинхронных задач
            futures.add(executorService.submit(() -> detManyThread(cur, executorService)));
        }
        for (var i = 0; i < a.length; i++) {
            var sign = (i % 2 == 0 ? 1 : -1);
            try {
                // получение результатов из объекта Future<T>
                result = result + sign * a[i][0] * futures.get(i).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    /**
     * Рекурсивный расчет определителя матрицы методом разложения по строке в один поток.
     *
     * @param a
     *          матрица
     * @return определитель матрицы
     */
    private static long detOneThread(long[][] a) {
        if (a.length == 1) {
            return a[0][0];
        }
        var result = 0L;

        for (var i = 0; i < a.length; i++) {
            var sign = (i % 2 == 0 ? 1 : -1);
            result = result + sign * a[i][0] * detOneThread(minor(a, i));
        }

        return result;
    }


    /**
     * Вычисляет минорную матрицу от заданной. Удаляется первый столбец и заданная строка.
     *
     * @param original
     *          матрица, от которой требуется вычислить минорную
     * @param exceptRow
     *          удаляемая строка
     * @return минорная матрица
     */
    public static long[][] minor(final long[][] original, int exceptRow) {
        long[][] minor = new long[original.length-1][original.length-1];
        var minorLength = minor.length;
        for (int i = 0; i < exceptRow; i++) {
            System.arraycopy(original[i], 1, minor[i], 0, minorLength);
        }
        for (int i = exceptRow + 1; i < original.length; i++) {
            System.arraycopy(original[i], 1, minor[i - 1], 0, minorLength);
        }
        return minor;
    }

    /**
     * Выводит в консоль результат работы.
     *
     * @param method
     *          название метода расчета
     * @param matrix
     *          матрица из предложенных для примера
     * @param executor
     *          алгоритм расчета определителя матрицы
     */
    private static void printResult(String method, MatrixExample matrix, Supplier<Long> executor) {
        var start = System.currentTimeMillis();
        var det = executor.get();
        var executionTime = (System.currentTimeMillis() - start);
        System.out.println("Method -> " + method);
        System.out.println("Matrix name -> " + matrix.name());
        System.out.println("Matrix dimension -> " + matrix.getMatrix().length);
        System.out.println("Matrix determinant  = " + det + (det != matrix.getDeterminant() ? " ERROR!" : ""));
        System.out.println("Execution time -> " + executionTime);
        System.out.println();
    }
}