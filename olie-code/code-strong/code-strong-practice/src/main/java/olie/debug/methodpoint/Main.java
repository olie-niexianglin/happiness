package olie.debug.methodpoint;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/9/16 21:44
 * @Description:
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Main().asyncExample();
    }
    private void asyncExample() throws InterruptedException, ExecutionException
    {
        final CompletableFuture<String> future = supplyAsync(() -> "F").thenApplyAsync(this::append_oo);
        System.out.println(future.get());
    }

    private String append_oo(String str)
    {
        return str +"oo";
    }
}
