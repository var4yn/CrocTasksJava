package device;

import storage.CDDisc;
import storage.MusicStorage;

/**
 * Устройство, способное воспроизводить музыку с CD Дисков
 */
public class CDPlayer extends MusicDevice {

    @Override
    protected boolean isValidStorage(MusicStorage musicStorage) {
        return musicStorage instanceof CDDisc;
    }
}
