package storage;

import music.Music;


import java.util.HashSet;

/**
 * ����������� ����� ��������� ������.
 * ����� ������ ��� ���������� ������ � �������� ��������� �� ������ � ���������.
 */
public abstract class MusicStorage {
    private HashSet<Music> musicList;

    public MusicStorage() {
        musicList = new HashSet<>();
    }

    public void addMusic(Music music) {
        if(music == null) return; // ������������ null
        musicList.add(music);
    }

    public void removeMusic(Music music) {
        musicList.remove(music);
    }

    public boolean findMusic(Music music) {
        return musicList.contains(music);
    }

}
