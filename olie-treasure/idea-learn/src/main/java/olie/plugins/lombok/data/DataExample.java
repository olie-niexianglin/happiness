package olie.plugins.lombok.data;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/8/14 19:43
 * @Description:
 */
import lombok.*;

@Data public class DataExample {

    private final String name;
    @Setter(AccessLevel.PACKAGE) private int age;
    private double score;
    private String[] tags;


    @ToString(includeFieldNames=true)
    @Data(staticConstructor="of")
    public static class Exercise<T> {
        private final String name;
        private final T value;
    }
}
