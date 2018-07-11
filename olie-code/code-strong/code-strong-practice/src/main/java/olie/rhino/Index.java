package olie.rhino;


import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/10 15:02
 * @Description: rhino 是 java版 的 javascript 引擎，是得可以在 java 语言中动态执行 js 脚本。
 */
public class Index {
    public static void main(String[] args) {
        Context cx = Context.enter();
        try {
            Scriptable scope = cx.initStandardObjects();
            //直接运行字符串类型表达式
            String str = "Math.PI*(1+2)";
            Object result = cx.evaluateString(scope, str, null, 1, null);
            double res = Context.toNumber(result);
            System.out.println(res);
        } finally {
            Context.exit();
        }
    }
}