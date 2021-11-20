package com.nativesystem;

import android.content.Context;
import com.dermandar.p047a.C1693n.C1686a;

public class Core {
    /* renamed from: a */
    public static Context f9753a;
    /* renamed from: b */
    public static C1686a f9754b = null;

    static {
        System.loadLibrary("corenew");
    }

    public static native boolean CompassInterference();

    public static native void beginStitching(int i, int i2);

    public static native boolean canTakePhoto();

    public static native boolean cancelPreparingToShoot();

    public static native void clear();

    public static native void decodeYUV420SP(int[] iArr, byte[] bArr, int i, int i2, boolean z, boolean z2);

    public static native boolean deviceHorizontal();

    public static native boolean deviceVertical();

    public static native void finishStitching();

    public static native int getDirection();

    public static native int getFx();

    public static native float getHeading(float f);

    public static native boolean getMaxFxReached();

    public static native int getPanoHeight(boolean z);

    public static native double getPercentage();

    public static native double getPitch();

    public static native double getRoll();

    public static native double getangle();

    public static native double getp();

    public static native double getr();

    public static native double gety1();

    public static native double gety2();

    public static native void init2(int i, String str, boolean z);

    public static native boolean isPreparingToShoot();

    public static native boolean isWhiteLabeled();

    public static native void loadImage(byte[] bArr, int i, int i2, double d, double d2, double d3, double d4);

    public static native void photoReady(boolean z);

    public static native void photoReady1(boolean z, double d);

    public static native void readExposure(byte[] bArr);

    public static native void set();

    public static native void setF35(double d);

    public static native void setIsLandscapeShot(boolean z);

    public static native void setSavePath(String str);

    public static native void startShooting();

    public static native void takingPhoto();

    public static native void updateCompass(double[] dArr, double[] dArr2, double d);

    public static native void updateGyro(double[] dArr, double[] dArr2, double[] dArr3);
}
