import device.CDPlayer;
import device.MP3Player;
import device.MusicDevice;
import device.Vinyl;
import exception.InvalidMusicStorageException;
import exception.NoMusicOnStorageException;
import music.Music;
import storage.CDDisc;
import storage.MusicStorage;
import storage.Plate;
import storage.USB;

/**
 * ����������� ������� 0__0
 *
 *
 * ��� ������� ������������ ���������� ���� ��� �������������� ��������� ������
 * ��������� ������ (��������) ������ ������
 * ������ ����� �������� ����� � �������� �����������
 *
 * ��������������� ���������� ������� ���������, ��� ��������� �������������� �� [�����������]
 *  � ���������, ��� ��������� ������ �������� � ������� ���������.
 */
public class Main {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        // �������� ������
        var cdDisc = new CDDisc();
        var usb = new USB();
        var music = new Music("Personal Jesus", "Depeche Mode");

        usb.addMusic(music); // �������� ������ �� ��������
        cdDisc.addMusic(music); // �������� ������ �� ��������

        // �������� �� �������� ��������������� � ������������ ��������
        printTest(new CDPlayer(), cdDisc, music);

        // �������� �� ���������� ��-�� �������������� ��������
        printTest(new CDPlayer(), usb, music);

        // �������� �� ����������, ���� ������ ��� � ���������
        cdDisc.removeMusic(music);
        printTest(new CDPlayer(), cdDisc, music);

        // �������� ��� ���������� �� ������ ������������� ������ � ������� ���������
        printTest(new MP3Player(), new USB(), new Music("everything i wanted", "Billie Eilish"));


        // �������� ���������
        //bruteTest(musicDevices, musicStorages, musics);

    }

    /**
     * ����� ��������� � ������� � ���������� ����������, ������� ����� ��������� Device
     * @param device - ���������� ��� ��������������� ������
     * @param musicStorage - ��������� ������
     * @param music - �����
     */
    private static void printTest(MusicDevice device, MusicStorage musicStorage, Music music) {
        try {
            device.play(musicStorage, music);
        } catch (InvalidMusicStorageException | NoMusicOnStorageException e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }


    // �������
    private static void bruteTest() {
        // ������, ������� ����� � ����������
        Music[] musics = {
                new Music("Personal Jesus", "Depeche Mode"),
                new Music("Dead Inside", "yunggoth"),
        };
        // ����������
        MusicDevice[] musicDevices = {
                new Vinyl(),
                new CDPlayer(),
                new MP3Player(),
        };
        // ���������
        MusicStorage[] musicStorages = {
                new Plate(),
                new CDDisc(),
                new USB(),
        };

        // �� ��� ��������� ������� ������
        for(var musicStorage : musicStorages) {
            for(var music : musics) {
                musicStorage.addMusic(music);
            }
        }

        // ��������, ��� ���������� ������������� ������ ������ � ��������������� ����������
        for(var musicDevice : musicDevices) {
            // ����� �� ������� ���������

            System.out.println("�������� ��� ����������: " + musicDevice.getClass().getName());
            for(var musicStorage : musicStorages) {
                // ����� �� ������ ������, ������� ���� � ���������
                for(var music : musics) {
                    printTest(musicDevice, musicStorage, music);
                }
            }
            System.out.println();
        }
    }

}
