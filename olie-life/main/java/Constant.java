import javax.xml.bind.SchemaOutputResolver;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2018/11/23
 * Time: 15:46
 * Desc: constant
 */
public class Constant {
    public static final int constant_int = 753;

    public static int getConstant_int() {
        return constant_int;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = "hello".getBytes("UTF-8");

        for (int i = 0; i < bytes.length; i++) {
            byte aByte = bytes[i];
            System.out.printf("" + aByte);
        }

    }


    /**
     * sssss
     */
    private String name;

    /**
     * 获取 sssss
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 sssss
     */
    public void setName(String name) {
        this.name = name;
    }


}
