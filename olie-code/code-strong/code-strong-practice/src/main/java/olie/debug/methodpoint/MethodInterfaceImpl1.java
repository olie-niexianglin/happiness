package olie.debug.methodpoint;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/9/16 21:44
 * @Description:
 */
public class MethodInterfaceImpl1 implements MethodInterface {
    @Override
    public void methodBreakPoint() {
        System.out.printf("MethodInterfaceImpl1");
    }
}
