package olie.plugins.lombok.nonnull;

import lombok.NonNull;

public class NonNullExample extends Something {
    private String name;

    public NonNullExample(@NonNull Person person) {
        super("Hello");
//        if (person == null) {
//            throw new NullPointerException("1person is marked @NonNull but is null");
//        }
        this.name = person.getName();

    }
}

class Something {
    public Something(String str) {

    }
}

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}