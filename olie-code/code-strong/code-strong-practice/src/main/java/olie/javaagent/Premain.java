package olie.javaagent;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/27 14:06
 * @Description:
 */
public class Premain {
    public static void premain(String agentArgs, Instrumentation inst)
            throws ClassNotFoundException, UnmodifiableClassException {
        inst.addTransformer(new Transformer());
    }
}
