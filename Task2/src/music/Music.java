package music;

/**
 * ������ ������������� �������� ����� � �����������
 */
public class Music {
    private final String title;
    private final String groupName;

    /**
     * �����������
     * @param title - �������� �����
     * @param groupName - �������� �����������
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
