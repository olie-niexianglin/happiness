package olie.debug;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/31 09:21
 * @Description:
 */
public class MethodBreakpoint {

    /*
      MethodBreakpoint:在指定方法阻塞，可以设定方法进入时阻塞，方法返回时阻塞
    */
    public static void main(String[] args) {
        MethodBreakPintEntry();
    }

    public static void MethodBreakPintEntry() {
        System.out.printf("MethodBreakPintEntry");

        System.out.printf("MethodBreakPintExit");
    }

}
