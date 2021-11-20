package com.nativesystem;

public class DMDXMP {
    static {
        System.loadLibrary("DMD_XMP");
    }

    public static native boolean writeXMPHeader(String str, int i, int i2, boolean z, double d, String str2);
}
