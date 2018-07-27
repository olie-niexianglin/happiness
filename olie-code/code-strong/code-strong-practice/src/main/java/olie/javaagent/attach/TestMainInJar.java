package olie.javaagent.attach;

import olie.javaagent.TransClass;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/27 14:45
 * @Description:
 */
public class TestMainInJar {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TransClass().getNumber());
        int count = 0;
        while (true) {
            Thread.sleep(5000);
            count++;
            int number = new TransClass().getNumber();
            System.out.println(number);
            if (3 == number || count >= 10) {
                break;
            }
        }
    }
}
