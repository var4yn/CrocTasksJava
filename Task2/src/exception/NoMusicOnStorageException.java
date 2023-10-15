package exception;

/**
 * Исключение возникающее, если музыки нет в хранилище
 */
public class NoMusicOnStorageException extends Exception {
    public NoMusicOnStorageException(String title, String groupName, String storageName) {
        super(String.format("Музыки с названием %s в исполнении %s нет в хранилище %s", title, groupName, storageName));
    }
}
