package device;

import storage.MusicStorage;
import storage.USB;

/**
 * ����������, ��������� �������������� ������ � USB
 */
public class MP3Player extends MusicDevice {

    @Override
    protected boolean isValidStorage(MusicStorage musicStorage) {
        return musicStorage instanceof USB;
    }
}
