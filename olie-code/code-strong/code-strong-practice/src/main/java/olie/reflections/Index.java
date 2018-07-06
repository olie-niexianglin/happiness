package olie.reflections;

import olie.reflections.annotation.Reflection;
import olie.reflections.annotation.ReflectionConstructor;
import olie.reflections.annotation.ReflectionField;
import olie.reflections.annotation.ReflectionParam;
import olie.reflections.subTypes.SubTypeOne;
import org.reflections.Reflections;
import org.reflections.scanners.*;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/3 13:34
 * @Description:
 */


/*
        Reflections one-stop-shop object
        Reflections scans your classpath, indexes the metadata,
        allows you to query it on runtime and may save and collect that information for many modules within your project.

        Using Reflections you can query your metadata such as:

        get all subtypes of some type (查找指定类型的子类)
        get all types/constructors/methods/fields annotated with some annotation, optionally(支持注解参数匹配) with annotation parameters matching
        get all resources matching matching a regular expression(查找所有资源文件)
        get all methods with specific signature including parameters, parameter annotations and return type
        get all methods parameter names(查找参数名称)
        get all fields/methods/constructors usages in code
 */






public class Index {

    public static void main(String[] args) {

        // A typical use of Reflections would be:

        Reflections reflections = new Reflections("olie.reflections");

        Set<Class<? extends SubTypeOne>> subTypes = reflections.getSubTypesOf(SubTypeOne.class);


        // Basically, to use Reflections first instantiate it with one of the constructors,
        // then depending on the scanners, use the convenient query methods:


        reflections = new Reflections("olie.reflections");

        // or

        reflections = new Reflections(ClasspathHelper.forPackage("olie.reflections"),
                new SubTypesScanner(false),
                new TypeAnnotationsScanner(),
                new ResourcesScanner(),
                new MethodAnnotationsScanner(),
                new FieldAnnotationsScanner(),
                new MethodParameterScanner(),
                new MemberUsageScanner());


        // And then query, for example:

        Set<Class<? extends SubTypeOne>> modules = reflections.getSubTypesOf(SubTypeOne.class);

        for (Class<? extends SubTypeOne> subType : modules) {
            System.out.println(subType.getSimpleName());
        }

        Set<Class<?>> singletons = reflections.getTypesAnnotatedWith(Reflection.class);


        for (Class<?> subType : singletons) {
            System.out.println(subType.getSimpleName());
        }


        Set<String> properties = reflections.getResources(Pattern.compile(".*\\.properties"));

        for (String propertie : properties) {
            System.out.println(propertie);
        }

        Set<Constructor> injectables = reflections.getConstructorsAnnotatedWith(ReflectionConstructor.class);

        for (Constructor constructor : injectables) {
            System.out.println(constructor.getName());
        }

        Set<Method> deprecateds = reflections.getMethodsAnnotatedWith(Deprecated.class);

        for (Method method : deprecateds) {
            System.out.println(method.getName());
        }


        Set<Field> ids = reflections.getFieldsAnnotatedWith(ReflectionField.class);

        for (Field field : ids) {
            System.out.println(field.getName());
        }


        Set<Method> someMethods = reflections.getMethodsMatchParams(AtomicBoolean.class, BigDecimal.class);

        for (Method method : someMethods) {
            System.out.println(method.getName());
        }

        Set<Method> voidMethods = reflections.getMethodsReturn(void.class);

        for (Method method : voidMethods) {
            System.out.println(method.getName());
        }


        Set<Method> pathParamMethods = reflections.getMethodsWithAnyParamAnnotated(ReflectionParam.class);
        for (Method method : pathParamMethods) {
            System.out.println(method.getName());

            Set<Member> methodUsage = reflections.getMethodUsage(method);

            for (Member member : methodUsage) {
                System.out.printf("--" + member.getName());
            }
        }

        Set<String> allTypes = reflections.getAllTypes();

        for (String type : allTypes) {
            System.out.println(type);
        }

    }



}
