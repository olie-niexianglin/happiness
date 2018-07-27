package olie;

import java.io.PrintStream;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/10 23:05
 * @Description:
 */
public class RactorParamater {

    /**
     * Ctrl + Alt + P ：重构参数,
     */

    //重构之前
    public void sayHello() {
        System.out.printf("x");
    }

    //重构之后
    public void sayHello(String format) {
        System.out.printf(format);
    }


}
