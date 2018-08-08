package olie.debug;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/31 09:27
 * @Description:
 */
public class ExceptionBreakpoint {

    //在程序抛出异常时阻塞(可指定具体类)，不需要与源代码映射，即不需要再指定代码片段处设定断点
    public static void main(String[] args) {
        try {
            throw new breakpointException();
        } catch (breakpointException e) {
            e.printStackTrace();
        }
    }

}
