package device;

import storage.MusicStorage;
import storage.Plate;

/**
 * ����������, ��������� �������������� ������ � ��������� ���������
 */
public class Vinyl extends MusicDevice {
    @Override
    protected boolean isValidStorage(MusicStorage musicStorage) {
        return musicStorage instanceof Plate;
    }
}
