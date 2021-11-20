package com.nativesystem;

public class YinYangLib {
    static {
        System.loadLibrary("corenew");
    }

    public static native void init(int i, int i2, boolean z);

    public static native void release();

    public static native void step();
}
