package exception;

/**
 * Исключение, возникающие при попытке музыкальным устройством прочитать недопустимое хранилище
 */
public class InvalidMusicStorageException extends Exception{
    public InvalidMusicStorageException(String nameDevice, String nameStorage) {
        super(nameDevice + " не поддерживает текущее хранилище : " + nameStorage);
    }
}
