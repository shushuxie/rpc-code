package com.xie.register;

import com.xie.common.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapRemoteRegister {

    public static Map<String, List<URL>> map = new HashMap<>();
    // 注册中心数据本地缓存机制
    // 数据变更监听机制
    public static void register(String interFaceName,URL url) {
        List<URL> list = map.get(interFaceName);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(url);
        map.put(interFaceName,list);
        saveFile();

    }

    public static List<URL> get(String interfaceName) {
        map = getFile();
        return map.get(interfaceName);
    }
    // 模拟注册中心数据
    public static void saveFile(){
        try {
            // output是相对内存来说的,从内存到磁盘是output,所以是写入
            FileOutputStream fileOutputStream = new FileOutputStream("registe-value.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(map);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Map<String,List<URL>> getFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream("registe-value.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
