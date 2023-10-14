package music;

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

}
