import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ������������ ������ BlackListFilterImpl.
 * �������� ������������, ���������� ����� �� blackList
 */
public class Main {
    public static void main(String[] args) {

        var filter = new BlackListFilterImpl();
        // ������ ������������
        var commentsList = Arrays.asList("�������� ���������", "������ ���� �� ��� ������");
        // ��������� ���� �� ������� ������
        var badWords = Arrays.asList("���������", "����");

        List<String> comments = new ArrayList<>(commentsList);
        Set<String> blackList = new HashSet<>(badWords);

        // ��������� �����������, ������� �� �������� ���� �� blackList
        filter.filterComments(comments, blackList);
        for(var i : comments) {
            System.out.println(i);
        }
    }
}
