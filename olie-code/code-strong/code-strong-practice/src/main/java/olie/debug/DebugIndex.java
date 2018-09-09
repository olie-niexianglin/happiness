package olie.debug;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/4 14:42
 * @Description:
 */
public class DebugIndex {

    public static void main(String[] args) {



        // force step into 可以进入sdk 中的方法

		System.out.printf("Start");

        // shift f7 可以选择进入[F7,embedF7,embedembedF7]
        F7(embedF7(embedembedF7()));

        // drop frame 允许你重新来过，牛
        dropFrame();


    }

    public static void F7(Object object) {
        System.out.printf("F7");
    }

    public  static  Object embedF7(Object objec) {
        return new Object();
    }

    public  static  Object embedembedF7() {
        return new Object();
    }


    //还有这种操作，可以反悔，重新调试的
    public static void dropFrame() {

        String _dropFrame  = "Drop Frame";
        _dropFrame = dropFrameNext1();

        System.out.printf(_dropFrame);
    }
    public static String dropFrameNext1() {

        String _dropFrame  = "Drop Frame Next1";

        _dropFrame = dropFrameNext2();

        return _dropFrame;
    }

    public static String dropFrameNext2() {

        String _dropFrame  = "Drop Frame Next2";

        return _dropFrame;
    }

}
