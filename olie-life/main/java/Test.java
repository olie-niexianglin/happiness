import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/6/27 08:35
 * @Description:
 */
public class Test {


    private static int state = 0;

    public static void main(final String[] args) {

        List<Integer> ss = new ArrayList<>();
        ss.add(2);
        ss.add(1);
        ss.add(3);
        ss.add(4);
        Collections.sort(ss);

        System.out.printf("");
    }
}

class ChangeClass implements Comparable<ChangeClass>{
    private final  int p = 10;

    @Override
    public int compareTo(@NotNull ChangeClass o) {
        return this.p - o.p;
    }
}
