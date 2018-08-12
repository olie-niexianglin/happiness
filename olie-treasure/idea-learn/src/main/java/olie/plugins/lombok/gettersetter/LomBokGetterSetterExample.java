package olie.plugins.lombok.gettersetter;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/8/12 17:21
 * @Description:
 */

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class LomBokGetterSetterExample {

    private int age = 10;

    private String name;

    @Override
    public String toString() {
        return String.format("%s (age: %d)", name, age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    protected void setName(String name) {
        this.name = name;
    }
}
