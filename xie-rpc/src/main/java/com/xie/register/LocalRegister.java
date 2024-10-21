package com.xie.register;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LocalRegister {
    public static Map<String,Class> map = new HashMap<>();
    public static void register(String interFaceName, String version,Class implClass) {
        map.put(interFaceName+version,implClass);
    }

    public static Class get(String interFaceName,String version) {
        return map.get(interFaceName+version);
    }

    public static void registerClass() {
        Set<Map.Entry<String, Class>> entries = map.entrySet();
        for(Map.Entry<String, Class> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue().getName());
        }

    }
}
