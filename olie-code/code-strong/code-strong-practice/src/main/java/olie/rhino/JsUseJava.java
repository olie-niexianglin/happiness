package olie.rhino;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/10 15:29
 * @Description: javascript 调用 java 变量和方法
 */
public class JsUseJava {

    public static void main(String[] args) {
        jsUseJavaFucniton();
        jsUseJavaVaraible();
    }

    private static void jsUseJavaFucniton() {
        Context ct = Context.enter();
        Scriptable scope = ct.initStandardObjects();
        String str = "var test={};";
        str += "test.call=function(){return 'Successful!';};";
        str += "java.lang.System.out.println(test.call())";
        ct.evaluateString(scope, str, null, 1, null);

    }

    private static void jsUseJavaVaraible() {
        Context ct = Context.enter();
        Scriptable scope = ct.initStandardObjects();
        String str = "var test={};";
        str += "test.call=function(param){return param ;};";
        str += "test.call(java.lang.Integer.MAX_VALUE)";
        Object result = ct.evaluateString(scope, str, null, 1, null);
        System.out.printf(result.toString());

    }
}
