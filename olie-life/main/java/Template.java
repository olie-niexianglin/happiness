import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2018/11/8
 * Time: 17:02
 * Desc: 一个文件模板例子
 */
public class Template {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws RuntimeException {

        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean add;
        if (arrayList.add(1)) {
            add = true;
        } else {
            add = false;
        }

        boolean a = false;
        boolean b = true;
        if (!a || !b) {
             new Template().sayHello("那么");
            new Template().setName("sa");
        }

    }

    private void sayHello(String content) {

    }
}
