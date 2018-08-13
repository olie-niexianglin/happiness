package olie.plugins.lombok.equalsandhashcode;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/8/12 20:58
 * @Description:
 */

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EqualsAndHashCodeExample {
    private transient int transientVar = 10;
    private String name;
    private double score;
    @EqualsAndHashCode.Exclude private Shape shape = new Square(5, 10);
    private String[] tags;
    @EqualsAndHashCode.Exclude private int id;

    public String getName() {
        return this.name;
    }

    @EqualsAndHashCode(callSuper=true)
    public static class Square extends Shape {
        private final int width, height;

        public Square(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }


    public static class Shape {
        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shape shape = (Shape) o;
            return name != null ? name.equals(shape.name) : shape.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

}
