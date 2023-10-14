package exception;

/**
 * ����������, ����������� ��� ������� ����������� ����������� ��������� ������������ ���������
 */
public class InvalidMusicStorageException extends Exception{
    public InvalidMusicStorageException(String nameDevice, String nameStorage) {
        super(nameDevice + " �� ������������ ������� ��������� : " + nameStorage);
    }
}
