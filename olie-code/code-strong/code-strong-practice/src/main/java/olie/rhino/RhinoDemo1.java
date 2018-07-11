package olie.rhino;

import com.google.common.io.Resources;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.net.URL;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/10 15:20
 * @Description: 将第三方 js 引用作为输入流读取
 */
public class RhinoDemo1 {
    public static void main(String[] args) {
        Context ct = Context.enter();
        Scriptable scope = ct.initStandardObjects();

        URL url = Resources.getResource("test.js");
        File file = new File(url.getPath());
        try {
            LineNumberReader reader = new LineNumberReader(new FileReader(file));

            String temp = null;
            StringBuffer sb = new StringBuffer();
            while((temp = reader.readLine()) != null){
                sb.append(temp).append("\n");
            }
            ct.evaluateString(scope, sb.toString(), null, 1, null);
            Object result = ct.evaluateString(scope, "test();", null, 1, null);
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            ct.exit();
        }
    }
}
