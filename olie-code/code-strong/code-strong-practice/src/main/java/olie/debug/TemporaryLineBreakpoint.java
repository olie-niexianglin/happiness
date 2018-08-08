package olie.debug;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/31 09:14
 * @Description:
 */
public class TemporaryLineBreakpoint {

    /*
    *  These breakpoints are assigned to lines of source code and are
    *  used to target a particular section	for debugging. When hit,
    *  such breakpoints are immediately removed.
    *  TemporaryLineBreakpoint:暂时的行代码断点，阻塞一次之后会立即失效
    */
    public static void main(String[] args) {

        System.out.printf("First Suspend");

        System.out.printf("Code End");

    }
}
