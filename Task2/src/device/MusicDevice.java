package device;

import exception.InvalidMusicStorageException;
import exception.NoMusicOnStorage;
import music.Music;
import storage.MusicStorage;

/**
 * ����������� ����� ������������ ����������
 */
public abstract class MusicDevice {

    /**
     * ��������� �������� �� ������� ���������� ������������� ������ � ������������� ��������
     * @param musicStorage - ����� �������� ������
     * @return true - ���� �������� �������������� �����������, ����� false
     */
    abstract boolean isValidStorage(MusicStorage musicStorage);

    /**
     * ������������� ��������� ����� � ���������� ���������
     * @param musicStorage - ����� �������� ������
     * @param music - �����
     * @throws InvalidMusicStorageException - �������������, ���� ����������� ��������� �� �������������� �����������
     * @throws NoMusicOnStorage - �������������, ���� ����� ��� � ���������
     */
    public void play(MusicStorage musicStorage, Music music) throws InvalidMusicStorageException, NoMusicOnStorage {
        // �������� �� null
        if(musicStorage == null) {
            throw new NullPointerException();
        }
        // ��������: �������� �� ����������� ���������� ��������� ������ � ��������
        if (!isValidStorage(musicStorage)) {
            throw new InvalidMusicStorageException(this.getClass().getName(), musicStorage.getClass().getName());
        }
        // ��������, ��� ������ ���� � ���������
        if(!musicStorage.findMusic(music)) {
            throw new NoMusicOnStorage(music.getTitle(), music.getGroupName());
        }

        // � ������ ������
        System.out.printf("���������� %s ������� ������������ � ��������� %s ����� %s � ���������� %s%n",
                this.getClass().getSimpleName(), musicStorage.getClass().getSimpleName(), music.getTitle(), music.getGroupName());

    }
}
