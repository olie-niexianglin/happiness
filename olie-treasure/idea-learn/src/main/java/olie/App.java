package olie;

import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws InterruptedException {


        c();


    }

    public static void c(){
        try {
            throw new E1();
        } catch (E1 e1) {
            try {
                E2 e2 = new E2();
                e2.initCause(e1);
                throw  e2;
            } catch (E2 e2) {
                RuntimeException runtimeException =  new RuntimeException();
                runtimeException.initCause(e2);
                throw runtimeException;
            }
        }
    }
}


class E1 extends Exception {
    public E1(String message, Throwable cause) {
        super(message, cause);
    }

    public E1() {
    }
}

class E2 extends Exception{
    public E2(String message, Throwable cause) {
        super(message, cause);
    }

    public E2() {
    }
}

