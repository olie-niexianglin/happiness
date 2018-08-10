package olie;

import org.jetbrains.annotations.NotNull;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/8/10 09:04
 * @Description:
 */
public class Annotations {

    public static void main(String[] args) {
        String content = getContent();
        sayHello(content);
    }

    public static void sayHello(@NotNull String content) {
        System.out.printf(content);

    }

    public static String getContent() {

        if (Math.random() > 0.5) {
            return "Hello World";
        }
        return null;
    }
}
