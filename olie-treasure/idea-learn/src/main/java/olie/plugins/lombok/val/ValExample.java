package olie.plugins.lombok.val;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;

public class ValExample {
    public String example() {
        val example = new ArrayList<String>();
//        final ArrayList<String> example = new ArrayList();
        example.add("Hello, World!");
        val foo = example.get(0);
//        final String foo = example.get(0)
        return foo.toLowerCase();


    }

    public void example2() {
        val map = new HashMap<Integer, String>();
        map.put(0, "zero");
        map.put(5, "five");
        for (val entry : map.entrySet()) {
            System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
        }
//        for (final Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
//        }
    }
}