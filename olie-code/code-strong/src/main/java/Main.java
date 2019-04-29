/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2018/12/29
 * Time: 17:38
 * Desc: Thread Main
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("Hello World!");
            }
        });
        thread.start();
    }
}
