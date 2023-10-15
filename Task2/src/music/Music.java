package music;

import java.util.Objects;

/**
 * Объект инкапсулирует названия песни и исполнителя
 */
public class Music {
    private final String title;
    private final String groupName;

    /**
     * Конструктор
     * @param title - название песни
     * @param groupName - название исполнителя
     */
    public Music(String title, String groupName) {
        this.title = title;
        this.groupName = groupName;
    }

    public String getTitle() {
        return title;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Music music)) return false;
        return title.equals(music.title) && groupName.equals(music.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, groupName);
    }
}
