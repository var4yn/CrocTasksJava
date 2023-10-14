package storage;

import music.Music;


import java.util.HashSet;

/**
 * Абстрактный класс хранилища музыки.
 * Имеет методы для добавления музыки и проверки находится ли музыка в хранилище.
 */
public abstract class MusicStorage {
    private HashSet<Music> musicList;

    public MusicStorage() {
        musicList = new HashSet<>();
    }

    public void addMusic(Music music) {
        if(music == null) return; // игнорируется null
        musicList.add(music);
    }

    public void removeMusic(Music music) {
        musicList.remove(music);
    }

    public boolean findMusic(Music music) {
        return musicList.contains(music);
    }

}
