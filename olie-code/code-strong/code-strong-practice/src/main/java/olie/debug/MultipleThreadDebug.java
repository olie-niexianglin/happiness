package olie.debug;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/4 15:31
 * @Description:
 */

/**
 * 多线程调试：
 *      右击断点，将断点挂起模式设置 Thread ,这样就可以一个线程一个线程
 *      的调试。
 *      因为在 ALL 模式下，当某一个线程挂起在该线程中的任意一个断点时，全部线程将同时被挂起，
 *      当断点位置重新被唤起时，其他线程也会同时执行，所以在调试线程1的时候，无法有效的控制线程2的执行
 *
 *      Thread 模式下：不同线程将被阻塞在不同的断点处，A 线程断点唤起不会影响到线程 B 断点的唤起与阻塞
 */

public class MultipleThreadDebug {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() { // 断点0
            @Override
            public void run() {
                System.out.println("1"); // 断点1
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2"); // 断点2
            }
        };
        t.setDaemon(false);
        t.start();
        t.setName("Hello World");
        // 外线程
        System.out.println("3"); // 断点3
        Thread.sleep(2000);
        System.out.println("4"); // 断点4
    }
}
