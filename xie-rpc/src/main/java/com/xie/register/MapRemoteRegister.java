package com.xie.register;

import com.xie.common.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapRemoteRegister {

    public static Map<String, List<URL>> map = new HashMap<>();
    public static void register(String interFaceName,URL url) {
        List<URL> list = map.get(interFaceName);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(url);
        map.put(interFaceName,list);
    }

    public static List<URL> get(String interfaceName) {
        return map.get(interfaceName);
    }
}
