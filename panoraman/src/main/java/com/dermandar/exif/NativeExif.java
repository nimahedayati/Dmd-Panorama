package com.dermandar.exif;

public class NativeExif {
    static {
        System.loadLibrary("ExifAnd");
    }

    public static native void allocInit(String str);

    public static native void dealloc();

    public static native boolean isValid();

    public static native float readGPSImageDirectionRaw();

    public static native String readUserComment();

    public static native void saveJPEG(String str);

    public static native void setMaxBufferSize(int i);

    public static native void writeGPSImageDirection(float f);

    public static native void writeGPSImageDirectionRef(char c);

    public static native void writeUserComment(String str);
}
