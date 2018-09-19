package olie.debug.methodpoint;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/9/16 21:43
 * @Description:
 */
public class MethodInterfaceImpl implements MethodInterface {
    @Override
    public void methodBreakPoint() {
        System.out.printf("MethodInterfaceImpl");
        int i = 1 / 0;
    }
}
