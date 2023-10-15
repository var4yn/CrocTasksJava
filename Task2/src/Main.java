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
 * Музыкальная система 0__0
 *
 *
 * Для каждого музыкального устройства есть своё поддерживаемое хранилище музыки
 * Хранилище музыки (носитель) хранит музыку
 * Музыка имеет название песни и название исполнителя
 *
 * Воспроизводящее устройство сначала проверяет, что хранилище поддерживается им [устройством]
 *  и проверяет, что выбранная музыка записана в текущем хранилище.
 */
public class Main {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        // тестовые данные
        var cdDisc = new CDDisc();
        var usb = new USB();
        var music = new Music("Personal Jesus", "Depeche Mode");

        usb.addMusic(music); // добавить музыку на носитель
        cdDisc.addMusic(music); // добавить музыку на носитель

        // проверка на успешное воспроизвидение с совместимого носителя
        printTest(new CDPlayer(), cdDisc, music);

        // провекра на исключение из-за несовместимого носителя
        printTest(new CDPlayer(), usb, music);

        // проверка на исключение, если музыки нет в хранилище
        cdDisc.removeMusic(music);
        printTest(new CDPlayer(), cdDisc, music);

        // проверка что устройство не сможет воспроизвести музыку с пустого хранилища
        printTest(new MP3Player(), new USB(), new Music("everything i wanted", "Billie Eilish"));


        // проверка перебором
        //bruteTest(musicDevices, musicStorages, musics);

    }

    /**
     * Вывод сообщений в консоль с обработкой исключений, которые может выбросить Device
     * @param device - устройство для выспроизвидения музыки
     * @param musicStorage - хранилище музыки
     * @param music - песня
     */
    private static void printTest(MusicDevice device, MusicStorage musicStorage, Music music) {
        try {
            device.play(musicStorage, music);
        } catch (InvalidMusicStorageException | NoMusicOnStorageException e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }


    // перебор
    private static void bruteTest() {
        // музыка, которая будет в хранилищах
        Music[] musics = {
                new Music("Personal Jesus", "Depeche Mode"),
                new Music("Dead Inside", "yunggoth"),
        };
        // устройства
        MusicDevice[] musicDevices = {
                new Vinyl(),
                new CDPlayer(),
                new MP3Player(),
        };
        // хранилища
        MusicStorage[] musicStorages = {
                new Plate(),
                new CDDisc(),
                new USB(),
        };

        // во все хранилища добавим музыку
        for(var musicStorage : musicStorages) {
            for(var music : musics) {
                musicStorage.addMusic(music);
            }
        }

        // проверка, что устройство воспроизводит музыку только с поддерживаемого устройства
        for(var musicDevice : musicDevices) {
            // бежим по каждому хранилищу

            System.out.println("Проверка для устройства: " + musicDevice.getClass().getName());
            for(var musicStorage : musicStorages) {
                // бежим по каждой музыке, которая есть в хранилище
                for(var music : musics) {
                    printTest(musicDevice, musicStorage, music);
                }
            }
            System.out.println();
        }
    }

}
