//package olie.javaagent.attach;
//
//import olie.javaagent.TransClass;
//import olie.javaagent.Transformer;
//import java.lang.instrument.Instrumentation;
//import java.lang.instrument.UnmodifiableClassException;
//
///**
// * @Auther: niexianglin you can mail to niexl@inspur.com
// * @Date: 2018/7/27 14:45
// * @Description:
// */
//public class AgentMain {
//    /**
//     * @param agentArgs
//     * @param inst
//     * @throws ClassNotFoundException
//     * @throws UnmodifiableClassException
//     * @throws InterruptedException
//     */
//    public static void agentmain(String agentArgs, Instrumentation inst)
//            throws ClassNotFoundException, UnmodifiableClassException,
//            InterruptedException {
//        inst.addTransformer(new Transformer (), true);
//        inst.retransformClasses(TransClass.class);
//        System.out.println("Agent Main Done");
//
//    }
//}
