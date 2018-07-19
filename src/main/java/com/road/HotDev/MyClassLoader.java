package com.road.HotDev;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义Java类，实现热加载
 */
public class MyClassLoader extends ClassLoader {
    private String classpath;

    public MyClassLoader(String classpath) {
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return super.findClass(name);
    }

    /**
     * 加载class文件
     *
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        try {
            name = name.replace(".", "//");
            FileInputStream is = new FileInputStream(new File(classpath + name + ".class"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = is.read()) != -1) {
                baos.write(b);
            }
            is.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
