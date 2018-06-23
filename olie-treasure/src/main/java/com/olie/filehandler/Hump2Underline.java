package com.olie.filehandler;

import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.awt.font.TextAttribute.UNDERLINE;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/6/1 17:25
 * @Description: 下划线命名方式转换为驼峰式命名
 */
public class Hump2Underline {

    public static final char UNDERLINE='_';
    public static void main(String[] args) {

        InputStream file = Hump2Underline.class.getClassLoader().getResourceAsStream("ActivitySqlMap.xml");
        File output = new  File(Hump2Underline.class.getClass().getResource("/").getPath()+"ActivitySqlMapResult.xml");
        try {
            InputStreamReader isr = new InputStreamReader(file);
            OutputStreamWriter outputs = new OutputStreamWriter(new FileOutputStream(output));
            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(outputs);
            PrintWriter pw = new PrintWriter(bw);
            String  temp = null;
            while ((temp = br.readLine())!=null) {
                System.out.println(temp);
                StringTokenizer st = new StringTokenizer(temp, ", ! \" {");

                while (st.hasMoreElements()) {
                    String _temp = st.nextElement().toString();
                    String _result = "";
                    if(Pattern.matches("^[a-z]+([A-Z][a-z]+)$", _temp)){
                        _result = ifHump(_temp);
                        temp = temp.replace(_temp,_result);
                    }
                }

                pw.println(temp);
            }
            pw.flush();
        } catch (Exception e) {
            // TODO: handle exception
        }

//        ifHump("activityTitle");
    }

    public static String camelToUnderline(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String ifHump(String source){

        String regexStr = "[A-Z]";
        Matcher matcher = Pattern.compile(regexStr).matcher(source);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String g = matcher.group();
            matcher.appendReplacement(sb, "_" + g.toUpperCase());
        }
        matcher.appendTail(sb);
        if (sb.charAt(0) == '_') {
            sb.delete(0, 1);
        }
        return sb.toString().toUpperCase();
    }
}

