package device;

import storage.MusicStorage;
import storage.Plate;

/**
 * Устройство, способное воспроизводить музыку с виниловых пластинок
 */
public class Vinyl extends MusicDevice {
    @Override
    protected boolean isValidStorage(MusicStorage musicStorage) {
        return musicStorage instanceof Plate;
    }
}
