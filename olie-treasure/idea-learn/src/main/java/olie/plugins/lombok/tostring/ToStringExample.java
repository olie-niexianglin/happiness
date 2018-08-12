package olie.plugins.lombok.tostring;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/8/12 20:19
 * @Description:
 */
import lombok.ToString;

import java.util.Arrays;

@ToString(doNotUseGetters=true)
public class ToStringExample {
    private static final int STATIC_VAR = 10;
    private String name;
    private Shape shape = new Square(5, 10);
    private String[] tags;
    @ToString.Exclude private int id;

    public String getName() {
        return this.name;
    }

    @ToString(callSuper=true, includeFieldNames=true)
    public static class Square extends Shape {
        private final int width, height;

        public Square(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    public static class Shape {
    }


}

