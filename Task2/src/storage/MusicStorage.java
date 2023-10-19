package storage;

import music.Music;


import java.util.HashSet;

/**
 * Абстрактный класс хранилища музыки.
 * Имеет методы для добавления музыки и проверки находится ли музыка в хранилище
 */
public abstract class MusicStorage {
    private HashSet<Music> musicSet;

    public MusicStorage() {
        musicSet = new HashSet<>();
    }

    public void addMusic(Music music) {
        if(music == null) return; // игнорируется null
        musicSet.add(music);
    }

    public void removeMusic(Music music) {
        musicSet.remove(music);
    }

    public boolean findMusic(Music music) {
        return musicSet.contains(music);
    }

}
