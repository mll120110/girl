package com.road.HotDev;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


/**
 * 加载manager工厂
 */
public class ManagerFactory {
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<String, LoadInfo>();
    public static final String CLASS_PATH = "";
    //实现热加载类全名称（包名+类名）
    public static final String MY_MANAGER = "";

    public static BaseManager getManager(String className) {
        File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        long lastModified = loadFile.lastModified();

        if (loadTimeMap.get(className) == null) {
            load(className, lastModified);
        } else if (loadTimeMap.get(className).getLoadTime() != lastModified) {
            load(className, lastModified);
        }
        return loadTimeMap.get(className).getBaseManager();
    }

    private static void load(String className, long loadFile) {

    }
}
