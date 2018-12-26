package olie.shortcutskey.debugging;

import javafx.scene.control.Toggle;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2018/12/24
 * Time: 13:36
 * Desc: Debugging ShortCut Learn
 */
public class DebuggingContent {


    /**
     * Step Over :
     * Click this button to execute the program until the next line in the current method or file,
     * skipping the methods referenced at the current execution point (if any).
     * If the current line is the last one in the method, execution steps to the line executed right after this method.
     *
     * 跳过该行，执行执行至下一行代码。若当前代码行存在其他方法调用，也会跳过，若当前代码行是当前方法的最后一行，则执行至当前方法之后的代码行
     * （其他方法）。
     *
     * F8
     */

    /**
     * Step Into :
     * Click this button to have the debugger step into the method called at the current execution point.
     * If stepping into the called method is suppressed through the Stepping page of the Settings dialog box
     * (for example, if it is of a standard Java SDK class or a simple getter), the method will be skipped.
     * Change the settings or use the Force Step Into command.
     *
     * 跳进该行的方法调用
     * 如果当前调用是 JDK 中提供的方法，那么 Step Into 并不会跳进方法调用内部，如果你想进去看看，那么你得使用 Force Step Into 代替 Step Into
     *
     * F7
     */

    /**
     * Smart Step Into :
     * Sometimes it happens that you stay at a line and want to step into a particular
     * method but not the first one that will be invoked.
     * In this case use Smart step into by pressing Shift+F7 to choose a particular method.
     * This is a great time-saver.
     *
     * 智能跳进目标方法调用
     * 如果当前行存在多级方法调用，但是你只希望跳进某一个方法内，那么 Smart Step Into 非常有用
     * Shift + F7
     */

    /**
     * Step Out :
     * Click this button to have the debugger step out of the current method, to the line executed right after it.
     *
     * 跳出当前方法：与 Step Over 不同，Step Out 直接跳出当前方法，方法执行到当前方法之后的代码行
     * Shift + F8
     */

    /**
     * Run to Cursor :
     * Click this button to resume program execution and pause until the execution point
     * reaches the line at the current cursor location in the editor.
     * No breakpoint is required. Actually, there is a temporary breakpoint set for the current line at the caret,
     * which is removed once program execution is paused.
     * Thus, if the caret is positioned at the line which has already been executed,
     * the program will be just resumed for further execution,
     * because there is no way to roll back to previous breakpoints.
     * This action is especially useful when you have stepped deep into the methods sequence and need to
     * step out of several methods at once.
     *
     * 调至光标处，不需要提前设置任何断点，你可以通过 Alt + F9 将调试程序运行至光标处代码行，但是你需要注意的是，光标处的代码行应该是
     * 尚未执行的片段(注意，若在执行到当前代码行之前的调用栈中存在断点，那么程序依然会在触发该断点)。
     *
     * Alt + F9
     */


    /**
     * Evaluate Expression  :
     *
     * Click this button to open the Evaluate Expression dialog.
     *
     * 表达式计算
     *
     * Alt + F8
     */

    /**
     * Resume Program :
     *
     * When an application is paused, click this button to resume program execution.
     *
     * 恢复程序执行
     * F9
     */

    /**
     *  Toggle breakpoint :
     *
     * When an application is paused, click this button to resume program execution.
     *
     * 创建或者删除断点，若当前行存在断点则删除该断点，若当前行不存在断点则在当前行创建断点
     * Ctrl+F8
     */

    /**
     *  View Breakpoints:
     *  Click this button to open the Breakpoints dialog where you can configure breakpoints behavior.
     *
     *  查看断点信息
     *  Ctrl+Shift+F8
     */




    public static void main(String[] args) {
        System.out.printf("Main-Start" + 1);
        method(Integer.valueOf(1));
        System.out.printf("Main-End" + 1);
    }

    private static void method(int i) {
        System.out.printf("Method Invoke Start");
        method2(i);
        System.out.printf("Method Invoke End");
    }

    private static void method2(int i) {
        System.out.printf("Method2 Invoke1");
        System.out.printf("Method2 Invoke2");
        System.out.printf("Method2 Invoke3");
        System.out.printf("Method2 Invoke4");
    }
}
