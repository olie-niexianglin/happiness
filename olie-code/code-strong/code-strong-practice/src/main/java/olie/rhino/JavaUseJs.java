package olie.rhino;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/10 15:25
 * @Description: java 程序中调用 js 变量和方法
 */
public class JavaUseJs {


    public static void main(String[] args) {
        javaUseJsVariable();
        javaUseJsFunction();
    }

    private static void javaUseJsVariable() {
        Context ct = Context.enter();
        Scriptable scope = ct.initStandardObjects();
        ct.evaluateString(scope, "var test = 'Successful';", null, 1, null);
        Object jsObject = scope.get("test", scope);
        if (jsObject == Scriptable.NOT_FOUND) {
            System.out.println("test is not defined.");
        } else {
            System.out.println("test is " + Context.toString(jsObject));
        }
    }

    private static void javaUseJsFunction() {
        Context ct = Context.enter();
        Scriptable scope = ct.initStandardObjects();
        ct.evaluateString(scope,
                "function test(name){return 'Successful!' + name;}", null, 1, null);
        Object functionObject = scope.get("test", scope);
        if (!(functionObject instanceof Function)) {
            System.out.println("test is undefined or not a function.");
        } else {
            Object testArgs[] = {"Ceven"};
            Function test = (Function) functionObject;
            Object result = test.call(ct, scope, scope, testArgs);
            System.out.println(Context.toString(result));
        }
    }
}
