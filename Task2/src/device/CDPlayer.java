package device;

import storage.CDDisc;
import storage.MusicStorage;

/**
 * ����������, ��������� �������������� ������ � CD ������
 */
public class CDPlayer extends MusicDevice {

    @Override
    protected boolean isValidStorage(MusicStorage musicStorage) {
        return musicStorage instanceof CDDisc;
    }
}
