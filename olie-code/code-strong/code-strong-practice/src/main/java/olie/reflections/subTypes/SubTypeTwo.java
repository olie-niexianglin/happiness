package olie.reflections.subTypes;

import olie.reflections.annotation.ReflectionConstructor;
import olie.reflections.annotation.ReflectionField;
import olie.reflections.annotation.ReflectionParam;
import org.omg.PortableInterceptor.INACTIVE;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/3 14:07
 * @Description:
 */
public class SubTypeTwo extends SubTypeOne {

    @ReflectionField
    private String name;

    @ReflectionConstructor
    public SubTypeTwo() {
    }

    @Deprecated
    public void sayHello() {

    }

    private Integer whereAreYou(AtomicBoolean aBoolean , BigDecimal bDecimal) {
        return null;
    }

    private void iAmVoid() {

    }

    private int annotationParam(@ReflectionParam int param) {

        return Integer.parseInt("0");
    }

    private void useMethod() {
        annotationParam(1);
    }


}
