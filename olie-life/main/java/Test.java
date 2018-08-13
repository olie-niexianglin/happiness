import java.util.List;
import java.util.ArrayList;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/6/27 08:35
 * @Description:
 */
public class Test {


    public static void main(String[] args) {
        List<byte[]> bytes = new ArrayList<byte[]>();
        int i=0;
        while(true){
            bytes.add(new byte[5*1024*1024]);
            System.out.println("分配次数："+(++i));
        }

    }
}
