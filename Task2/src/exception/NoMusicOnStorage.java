package exception;

/**
 * ���������� �����������, ���� ������ ��� � ���������
 */
public class NoMusicOnStorage extends Exception {
    public NoMusicOnStorage(String title, String groupName) {
        super(String.format("������ � ��������� %s � ���������� %s ��� � ���������", title, groupName));
    }
}
