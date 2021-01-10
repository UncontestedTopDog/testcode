package com.yy.android.lib.annotataion;

import java.lang.reflect.Method;


public class AnnotataionClass {
    public static void main(String[] args) throws ClassNotFoundException {
        // String clazz = "com.yy.android.lib.annotataion.AnnotataionClass";
        // System.out.println("AAAAAAAAAAAAAAAAAAA");
        // Method[] demoMethod = AnnotataionClass.class.getClassLoader().loadClass(clazz).getMethods();
        // for (Method method : demoMethod) {
        //     if (method.isAnnotationPresent(MyAnnotation.class)) {
        //         MyAnnotation annotationInfo = method.getAnnotation(MyAnnotation.class);
        //         System.out.println("method: "+ method);
        //         System.out.println("name= "+ annotationInfo.name() +
        //                 " , size= "+ annotationInfo.size()
        //                 + " , revision= "+annotationInfo.revision());
        //     }
        // }
        TestClass testClass = new TestClass("A","10","B");
        testClass.toString();
    }



    @MyAnnotation(name = "AAA", size = "SMALL", revision =  10)
    public static void test() {

    }
}
