package olie.localhistory;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2018/12/19
 * Time: 16:57
 * Desc: 本地历史变化sse
 */
public class LocalHistory {
    private String filed = "sd";



    private void method() {
        System.out.printf("Method");
    }
    public static void main(String[] args) {

        System.out.printf("Hello Local History!");
        System.out.printf("Hello Local History!");
        System.out.printf("Hello Local History!");
        System.out.printf("Hello Local History!");
        System.out.printf("Hello Local History!");
        System.out.printf("Hello Local History!");
        System.out.printf("Hello Local History!");

        System.out.println("World World!");

        sayHelloToGoodMan();

        sayHelloToGoodWomen();
    }

    private static void sayHelloToGoodWomen() {
        System.out.printf("World");
    }

    private static void sayHelloToGoodMan() {
        System.out.printf("World");
    }
}
