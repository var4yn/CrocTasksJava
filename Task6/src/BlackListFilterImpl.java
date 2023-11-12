import java.util.List;
import java.util.Set;

/**
 * ���������� ���������� BlackListFilter
 */
public class BlackListFilterImpl implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        // ������� ������������ ����� ��������
        for(var iterator = comments.iterator(); iterator.hasNext(); ) {
            // ������� �����������
            var comment = iterator.next().toLowerCase();

            // ������� ���� ���� �� blackList
            for(var badWord : blackList) {
                /*  ���� � ����������� ���������� ����� �� ������� ������,
                    ����������� ��������� �� List<String> */
                if(comment.contains(badWord)) {
                    iterator.remove();
                    break;
                }
            }

        }


    }
}
