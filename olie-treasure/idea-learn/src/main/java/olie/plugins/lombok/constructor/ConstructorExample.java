package olie.plugins.lombok.constructor;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/8/12 20:58
 * @Description:
 */

import lombok.*;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED,staticName = "of1")
public class ConstructorExample<T> {
    private int x, y;
    @NonNull private T description;
    private final String name;
    private static String hello;

    @NoArgsConstructor
    public static class NoArgsExample {
        @NonNull private String field;
    }
}