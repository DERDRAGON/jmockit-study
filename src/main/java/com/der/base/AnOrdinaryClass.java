package com.der.base;

/**
 * <p> @ClassName AnOrdinaryClass </p>
 * <p> @Desctiption TODO </p>
 * <p> @Author 曹世龙 </p>
 * <p> @Date 2019/7/28 23:50 </p>
 * <p> @Version 1.0 </p>
 **/
public class AnOrdinaryClass {

    // 静态方法
    public static int staticMethod() {
        return 1;
    }

    // 普通方法
    public int ordinaryMethod() {
        return 2;
    }

    // final方法
    public final int finalMethod() {
        return 3;
    }

    // native方法,返回4
//    public native int navtiveMethod();

    // private方法
    private int privateMethod() {
        return 5;
    }

    // 调用private方法
    public int callPrivateMethod() {
        return privateMethod();
    }
}
