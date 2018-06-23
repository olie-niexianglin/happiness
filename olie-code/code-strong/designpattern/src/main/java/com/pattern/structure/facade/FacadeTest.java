package com.pattern.structure.facade;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niexianglin on 2016/9/15 13:17
 * Class Description:  为子系统中的一组接口提供一个一致的界面，外观模式定义了一个高层接口，这个接口使得子系统更加容易使用。
 *                     降低访问复杂系统的内部子系统时的复杂度。
 *                     关键代码：在客户端和复杂系统之间再加一层，这一层将调用顺序、依赖关系等处理好。
 */
public class FacadeTest {
    public static void main(String[] args) {
        EncryptFacade encryptFacade = new EncryptFacade("facade.txt");
        encryptFacade.encrypt();
    }
}
/*
    例子：
        某软件公司欲开发一个可应用于多个软件的文件加密模块，该模块可以对文件中的数据进行加密并将加密之后的数据存储在
        一个新文件中，具体的流程包括三个部分，分别是读取源文件、加密、保存加密之后的文件，其中，读取文件和保存文件使用流来实现，
        加密操作通过求模 运算实现。这三个操作相对独立，为了实现代码的独立重用，让设计更符合单一职责原则，这三个操作的业务代码封装在三个不同的类中。
        现使用外观模式设计该文件加密模块。
 */

class EncryptFacade{
    private ReaderSystem readerSystem;
    private EncryptionSystem encryptionSystem;
    private WriteSystem writeSystem;

    public EncryptFacade(String filepath) {
        readerSystem = new ReaderSystem(filepath);
        encryptionSystem = new EncryptionSystem();
        writeSystem = new WriteSystem(filepath);
    }
    public void encrypt(){
        List<Character> list = readerSystem.readFile();
        encryptionSystem.encrypt(list);;
        writeSystem.writeFile(list);
    }
}


class ReaderSystem{
    private File file;
    private List<Character> charlist;
    public ReaderSystem(String filepath) {
        file = new File(filepath);
        charlist = new ArrayList<Character>();
    }
    public List<Character> readFile(){
        int num = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(this.file)));
            char[] buffer = new char[1024];
            int temp = 0;
            while((temp=br.read(buffer))>0){
                for (int i = 0; i < temp; i++) {
                    charlist.add(buffer[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return charlist;
    }
}
class EncryptionSystem{
    private List<Character> charlist;

    public void encrypt(List<Character> charlist){
        this.charlist = charlist;
        if(charlist!=null && charlist.size()>0){
            for (int i = 0; i < charlist.size(); i++) {
                charlist.set(i, (char) (charlist.get(i)-1));
            }
        }
    }
}

class WriteSystem{
    private File file;
    private List<Character> charlist;
    public WriteSystem(String filepath) {
        file = new File(filepath);
    }

    public void writeFile( List<Character> charlist){
        this.charlist = charlist;
        BufferedWriter bw= null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.file)));
            char[] data = new char[charlist.size()];
            for (int i = 0; i <charlist.size() ; i++) {
                data[i] = charlist.get(i);
            }
            bw.write(data,0,data.length);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}