package olie.plugins.lombok.sneakythrows;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class SneakyThrowsExample implements Runnable {
    @SneakyThrows(UnsupportedEncodingException.class)
    public String utf8ToString(byte[] bytes) {
        return new String(bytes, "UTF-8");
    }

    @SneakyThrows
    public void run() {
        throw new Throwable();
    }
}