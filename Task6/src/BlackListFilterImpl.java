import java.util.List;
import java.util.Set;

/**
 * Реализация интерфейса BlackListFilter
 */
public class BlackListFilterImpl implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        // перебор комментариев через итератор
        for(var iterator = comments.iterator(); iterator.hasNext(); ) {
            // текущий комментарий
            var comment = iterator.next().toLowerCase();

            // перебор всех слов из blackList
            for(var badWord : blackList) {
                /*  если в комментарии содержится слово из черного списка,
                    комментарий удаляется из List<String> */
                if(comment.contains(badWord)) {
                    iterator.remove();
                    break;
                }
            }

        }


    }
}
