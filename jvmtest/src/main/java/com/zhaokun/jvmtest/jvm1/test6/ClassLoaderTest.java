package com.zhaokun.jvmtest.jvm1.test6;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }
                byte[] b = new byte[0];
                try {
                    b = new byte[is.available()];
                    is.read(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return defineClass(name, b ,0 , b.length);
            }
        };

        Object o = classLoader.loadClass("com.zhaokun.jvmtest.jvm1.test6.ClassLoaderTest").newInstance();
        System.out.println(o.getClass());
        System.out.println(o instanceof com.zhaokun.jvmtest.jvm1.test6.ClassLoaderTest);
        // class com.zhaokun.jvmtest.jvm1.test6.ClassLoaderTest
        // false

    }

}
