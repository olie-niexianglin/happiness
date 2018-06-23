
package com.pattern.create.factory;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by niexianglin on 2016/8/23 9:19
 */

public class SimpleFactory {
    public static void main(String[] args) {
        //简单工厂模式举例
        //Engineer engineer = EngineerFactory.getEngineer("development");
        //engineer.doSomething();

        //反射增强简单工厂模式
        Engineer engineer = new EngineerRFactory<String,Engineer>("settings.xml").getEngineer("test");
        engineer.doSomething();
    }
}

//-------------------------------------------------------------------简单工厂模式--------------------
interface Engineer {
    void doSomething();
}

class DevelopmentEngineer implements Engineer {
    public void doSomething() {
        System.out.println("Hello i am a developmentEngineer");
    }
}

class TestEngineer implements Engineer {
    public void doSomething() {
        System.out.println("Hello i am a testEngineer");
    }
}
class SecurityEngineer implements Engineer {
    public void doSomething() {
        System.out.println("Hello i am a securityEngineer");
    }
}
class EngineerFactory {
    public static Engineer getEngineer(String type) {
        Engineer engineer = null;
        if (type != null) {
            if (type.equals("development"))
                engineer = new DevelopmentEngineer();
            else if (type.equals("test"))
                engineer = new TestEngineer();
        }
        return engineer;
    }
}
//-------------------------------------------------------------------简单工厂模式--------------------

//---------------------------------------------------------------反射增强简单工厂模式--------------------
class EngineerRFactory<K,V> {
    private Map<K, V> beanMap = new HashMap<K, V>();

    public EngineerRFactory(String settingsFile) {
        this.init(settingsFile);
    }

    public void init(String settingsFile) {
        try {
            SAXReader reader = new SAXReader();
            InputStream ins = Thread.currentThread().getContextClassLoader().getResourceAsStream(settingsFile);
            Document doc = reader.read(ins);
            Element root = doc.getRootElement();
            Element element = null;
            for (Iterator i = root.elementIterator("engineer"); i.hasNext(); ) {
                element = (Element) i.next();
                Attribute id = element.attribute("type");
                Attribute cls = element.attribute("class");
                Class bean = Class.forName(cls.getText());
                V obj = (V)bean.newInstance();
                beanMap.put((K) id.getText(), obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  V getEngineer(String beanType) {
        V obj = beanMap.get(beanType);
        return obj;
    }
}
//---------------------------------------------------------------反射增强简单工厂模式--------------------
