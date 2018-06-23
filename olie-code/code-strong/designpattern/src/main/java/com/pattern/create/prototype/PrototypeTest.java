package com.pattern.create.prototype;

import java.io.*;

/**
 * Created by niexianglin on 2016/9/18 12:52
 * Class Description:   当直接穿件对象的代价比较大时，采用这种模式，例如，一个对象需要在一个高代价的数据库操作之后被创建，例如一些对象
 *                      属性需要从数据库中获取，然后利用这些属性创建对象。我们可以缓存该对象，在一个请求到来时，返回它的克隆。
 */
public class PrototypeTest {
    public static void main(String[] args) {
        SeriA seriA = new SeriA("SeriA");
        SeriB seriB = new SeriB("SeriB");

        ConcretePrototype cp = new ConcretePrototype();
        cp.setSeriA(seriA);
        cp.setSeriB(seriB);
        System.out.println(cp.getSeriA().toString().hashCode());

        ConcretePrototype cp_clone =  cp.clones();
        System.out.println(cp_clone.getSeriA().toString().hashCode());


    }
}

//抽象原型角色
interface Prototype {
    Object clones();
}

class ConcretePrototype implements Prototype,Serializable{
    private static final long serialVersionUID = 1L;
    private SeriA seriA;
    private SeriB seriB;

    public SeriA getSeriA() {
        return seriA;
    }

    public void setSeriA(SeriA seriA) {
        this.seriA = seriA;
    }

    public SeriB getSeriB() {
        return seriB;
    }

    public void setSeriB(SeriB seriB) {
        this.seriB = seriB;
    }

    @Override
    public ConcretePrototype clones() {
        return new CloneTools<ConcretePrototype>().Clone(this);
    }
}

//----------------辅助对象------------
class SeriA implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public SeriA(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name.toString();
    }
}

class SeriB implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public SeriB(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name.toString();
    }
}
//利用 对象序列化和反序列完成对象的深拷贝
class CloneTools<T> {
    private ByteArrayInputStream bis = null;
    private ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;

    public T Clone(Object obejct) {
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obejct);
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return (T)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}