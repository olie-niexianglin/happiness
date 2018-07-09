package olie.jmx;

import org.weakref.jmx.MBeanExporter;

import java.lang.management.ManagementFactory;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/6 11:33
 * @Description:
 */
public class Index {

    private static MBeanExporter exporter = new MBeanExporter(ManagementFactory.getPlatformMBeanServer());

    public static void main(String[] args) throws InterruptedException {

        HelloMBean mbean = new HelloMBean();
        exporter.export("MyMbean" + ":name=" + mbean.getClass().getCanonicalName(), mbean);

        CountDownLatch countDownLatch = new CountDownLatch(1);

        countDownLatch.await();
    }
}

