package olie;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/7 23:48
 * @Description:
 */
public class IdeaLearn {
    public static final String HELLO_WORLD = "Hello World";

    /**
     *  Ctrl + B : Navigate to declaration 导航至 Class Method Filed 定义的位置
     *  Ctrl + H : Navigate to type hierarchy 导航至文件的继结构
     */




    /**
     * Ctrl + Alt + C :将选中的字符串重构为一个常量
     */
    String name = HELLO_WORLD;
    String name1 = HELLO_WORLD;





    /**
     * Shift + Enter : 光标移到下一行，并不会修改当前行，例如，光标现在不在某一行的行位，执行上述
     * 操作后，光标会直接跳转到下一行，并不会修改当前行。
     */
    private String alias = "Hello Alias";

    public static void main(String[] args) {
//
//        System.out.printf("Hello Wolrd");
//
//        while (true) {
//            int i = 0;
//
//            if (i++ > 10) {
//                System.out.printf("i" + i);
//                break;
//            }
//        }

        int i =3;
        float f = Float.valueOf("3.000000");;

        if (i > f) {
            System.out.printf("1");
        } else {
            System.out.printf("2");

        }
    }


}
