package olie.reflections.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/3 13:54
 * @Description:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ReflectionParam {
    String value() default "";
}
