package device;

import exception.InvalidMusicStorageException;
import exception.NoMusicOnStorage;
import music.Music;
import storage.MusicStorage;

/**
 * Абстрактный класс музыкального устройство
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
     * @throws NoMusicOnStorage - выбрасывается, если песни нет в хранилище
     */
    public void play(MusicStorage musicStorage, Music music) throws InvalidMusicStorageException, NoMusicOnStorage {
        // проверка на null
        if(musicStorage == null) {
            throw new NullPointerException();
        }
        // проверка: способно ли музыкальное устройство прочитать музыку с носителя
        if (!isValidStorage(musicStorage)) {
            throw new InvalidMusicStorageException(this.getClass().getName(), musicStorage.getClass().getName());
        }
        // проверка, что музыка есть в хранилище
        if(!musicStorage.findMusic(music)) {
            throw new NoMusicOnStorage(music.getTitle(), music.getGroupName());
        }

        // в случае успеха
        System.out.printf("Устройство %s успешно воспроизвела с хранилища %s песню %s в исполнении %s%n",
                this.getClass().getSimpleName(), musicStorage.getClass().getSimpleName(), music.getTitle(), music.getGroupName());

    }
}
