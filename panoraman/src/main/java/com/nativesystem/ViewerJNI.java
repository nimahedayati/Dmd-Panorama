package com.nativesystem;

public class ViewerJNI {
    static {
        System.loadLibrary("dmdviewer");
    }

    public static native void cardboardVisibility(boolean z);

    public static native boolean click(double d, double d2, double d3, double d4);

    public static native boolean clickIsCardboard();

    public static native boolean clickIsGyro();

    public static native boolean clickIsHD();

    public static native boolean clickIsSD();

    public static native void dblclick(double d, double d2);

    public static native void draw();

    public static native void end();

    public static native boolean exportEqui(String str, int i, int i2, int i3);

    public static native boolean getCardboard();

    public static native int getErrorCode();

    public static native float getFovx();

    public static native boolean getGyro();

    public static native double getHeading();

    public static native void gyroVisibility(boolean z);

    public static native boolean isReady();

    public static native void mkaAutoplay();

    public static native void mkaCardboardVisibility(boolean z);

    public static native boolean mkaClick(double d, double d2, double d3, double d4);

    public static native boolean mkaClickIsGyro();

    public static native void mkaDblclick(double d, double d2);

    public static native void mkaDraw();

    public static native void mkaEnd();

    public static native float mkaGetFovx();

    public static native boolean mkaGetGyro();

    public static native char mkaGetType();

    public static native void mkaGyroVisibility(boolean z);

    public static native void mkaInit(int i, float f, String str);

    public static native boolean mkaIsReady();

    public static native void mkaMove(double d, double d2);

    public static native void mkaRelease();

    public static native void mkaSave(String str);

    public static native void mkaSetCardboard(boolean z);

    public static native void mkaSetDim(int i, int i2);

    public static native void mkaSetFovx(float f);

    public static native void mkaSetGyro(boolean z);

    public static native void mkaSetPPI(double d);

    public static native void mkaSetType(char c);

    public static native void mkaStart(double d, double d2);

    public static native void mkaUpdatePlayer();

    public static native boolean mkaView(String str, String str2);

    public static native void mkaZoom(double d);

    public static native void move(double d, double d2);

    public static native void release();

    public static native void setCardboard(boolean z);

    public static native void setDim(int i, int i2, float f);

    public static native void setGyro(boolean z);

    public static native void setHD(boolean z);

    public static native void setHeading(double d);

    public static native void setPPI(double d);

    public static native void start(double d, double d2);

    public static native void updateGyro(float[] fArr, float[] fArr2);

    public static native void view(boolean z, int i, String str, String str2, String str3, int i2, int i3, float f, int i4);

    public static native void zoom(double d);
}
