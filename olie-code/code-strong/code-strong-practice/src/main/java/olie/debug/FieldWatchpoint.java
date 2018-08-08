package olie.debug;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/31 09:39
 * @Description:
 */
public class FieldWatchpoint {

    static String name ;


    /**
     * FieldWatchpoint:在对象指定属性上阻塞
     */
    public static void main(String[] args) {
        //modify
        name = "FieldWatchpoint_New";
        //access
        String accessName = getName();
    }

    public static String getName() {
        return name;
    }
}
