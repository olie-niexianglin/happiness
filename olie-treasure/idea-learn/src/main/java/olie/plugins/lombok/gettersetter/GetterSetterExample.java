package olie.plugins.lombok.gettersetter;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/8/12 17:21
 * @Description:
 */

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class GetterSetterExample {

    @Getter
    @Setter
    private int age = 10;

    @Setter(AccessLevel.PROTECTED)
    private String name;

    @Override
    public String toString() {
        return String.format("%s (age: %d)", name, age);
    }
}


