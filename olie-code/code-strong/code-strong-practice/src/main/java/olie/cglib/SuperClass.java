package olie.cglib;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/5 10:27
 * @Description:
 */
public class SuperClass {

    private String name = "Hello";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String sayHello(boolean flag) {
        return "Hello World!";
    }
}
