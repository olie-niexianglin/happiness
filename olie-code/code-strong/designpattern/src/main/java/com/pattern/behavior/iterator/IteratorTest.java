package com.pattern.behavior.iterator;

/**
 * Created by niexianglin on 2016/9/18 20:50
 * Class Description:
 */
public class IteratorTest {
    public static void main(String[] args) {
        MyCollections myCollections = new MyCollections();
        MyIterator iterator = myCollections.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
class MyCollections{
    private String[] colls = new String[]{"1","2","3","4","5"};
    public String get(int index){
        return colls[index];
    }
    public int size(){
        return colls.length;
    }
    public MyIterator iterator(){
        return new MyIterator(this);
    }
}
class MyIterator {
    //提供一个顺序访问聚合对象的内部元素的方式，而又不需要暴露聚合对象的内部表示
    private MyCollections myCollections;
    private int pos = 0;
    public MyIterator(MyCollections myCollections) {
        this.myCollections = myCollections;
    }

    public boolean hasNext() {
        return myCollections.size()>pos;
    }

    public String next() {
        return myCollections.get(pos++);
    }
}

