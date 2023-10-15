package device;

import exception.InvalidMusicStorageException;
import exception.NoMusicOnStorageException;
import music.Music;
import storage.MusicStorage;

/**
 * Абстрактный класс музыкального устройста
 */
public abstract class MusicDevice {

    /**
     * Проверяет способно ли текущее устройство воспроизвести музыку с определенного носителя
     * @param musicStorage - место хранения музыки
     * @return true - если носитель поддерживается устройством, иначе false
     */
    abstract boolean isValidStorage(MusicStorage musicStorage);

    /**
     * Воспроизводит указанную песню с указанного хранилища
     * @param musicStorage - место хранения музыки
     * @param music - песня
     * @throws InvalidMusicStorageException - выбрасывается, если музыкальное хранилище не поддерживается устройством
     * @throws NoMusicOnStorageException - выбрасывается, если песни нет в хранилище
     */
    public void play(MusicStorage musicStorage, Music music) throws InvalidMusicStorageException, NoMusicOnStorageException {
        // проверка на null
        if(musicStorage == null) {
            throw new InvalidMusicStorageException(this.getClass().getName(), "NULL");
        }
        // проверка: способно ли музыкальное устройство прочитать музыку с носителя
        if (!isValidStorage(musicStorage)) {
            throw new InvalidMusicStorageException(this.getClass().getName(), musicStorage.getClass().getSimpleName());
        }
        // проверка: есть ли музыка в хранилище
        if(!musicStorage.findMusic(music)) {
            throw new NoMusicOnStorageException(music.getTitle(), music.getGroupName(), musicStorage.getClass().getSimpleName());
        }

        // в случае успеха
        System.out.printf("Устройство %s успешно воспроизвела с хранилища %s песню %s в исполнении %s%n",
                this.getClass().getSimpleName(), musicStorage.getClass().getSimpleName(), music.getTitle(), music.getGroupName());

    }
}
