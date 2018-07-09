package olie.jmx;

import org.weakref.jmx.Managed;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/6 11:33
 * @Description:
 */
public class HelloMBean {

    private String name;
    private int age;

    @Managed
    public void sayHello(String content) {
        System.out.printf("Hello World " + content);
    }

    @Managed
    public String getName() {
        return name;
    }

    @Managed
    public void setName(String name) {
        this.name = name;
    }

    @Managed
    public int getAge() {
        return age;
    }

    @Managed
    public void setAge(int age) {
        this.age = age;
    }

}
