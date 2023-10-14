package exception;

/**
 * Исключение возникающее, если музыки нет в хранилище
 */
public class NoMusicOnStorage extends Exception {
    public NoMusicOnStorage(String title, String groupName) {
        super(String.format("Музыки с названием %s в исполнении %s нет в хранилище", title, groupName));
    }
}
