package olie.plugins.lombok.var;

import lombok.experimental.var;
import lombok.val;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.HashMap;

public class VarExample {
    public void example() {
        var example = new ArrayList<String>();
        example.add("Hello, World!");

    }

}