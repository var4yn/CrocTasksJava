import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Демонстрация работы BlackListFilterImpl.
 * Удаление комментариев, содержащих слова из blackList
 */
public class Main {
    public static void main(String[] args) {

        var filter = new BlackListFilterImpl();
        // список комментариев
        var commentsList = Arrays.asList("постигла депрессия", "привет пока всё как всегда");
        // множество слов из черного списка
        var badWords = Arrays.asList("депрессия", "блиц");

        List<String> comments = new ArrayList<>(commentsList);
        Set<String> blackList = new HashSet<>(badWords);

        // оставляет комментарии, которые не содержат слов из blackList
        filter.filterComments(comments, blackList);
        for(var i : comments) {
            System.out.println(i);
        }
    }
}
