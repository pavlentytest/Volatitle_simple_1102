
public class Main {

    private volatile boolean flag;
    Runnable gui = () -> {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Stop gui!");
        flag = true;
    };

    Runnable logic = () -> {
        while(!flag) {
            // логика игры
        }
        System.out.println("Stop logic!");
    };

    void doStart() {
        new Thread(gui).start();
        System.out.println("Start gui!");
        new Thread(logic).start();
        System.out.println("Start logic!");
    }

    public static void main(String[] args) {
        new Main().doStart();
        // игровое приложение
        // 1 поток - GUI
        // 2 поток - Logic
    }
}