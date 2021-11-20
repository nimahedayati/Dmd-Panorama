package com.dermandar.p047a;

import android.os.Build;
import android.os.Build.VERSION;
import com.nativesystem.Core;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Queue;
import java.util.regex.Pattern;

/* renamed from: com.dermandar.a.x */
class C1753x {
    /* renamed from: A */
    public static int f5009A = 2048;
    /* renamed from: B */
    public static boolean f5010B = false;
    /* renamed from: C */
    public static boolean f5011C = false;
    /* renamed from: D */
    public static boolean f5012D = true;
    /* renamed from: E */
    public static boolean f5013E = false;
    /* renamed from: F */
    public static boolean f5014F = false;
    /* renamed from: G */
    public static int f5015G = 0;
    /* renamed from: H */
    public static int f5016H = 0;
    /* renamed from: I */
    public static Queue<C1754y> f5017I;
    /* renamed from: J */
    public static String f5018J;
    /* renamed from: K */
    public static int f5019K;
    /* renamed from: L */
    public static double f5020L = 0.0d;
    /* renamed from: M */
    public static double f5021M = 0.0d;
    /* renamed from: N */
    public static double f5022N = 0.0d;
    /* renamed from: O */
    public static int f5023O = 0;
    /* renamed from: P */
    public static int f5024P = 0;
    /* renamed from: Q */
    public static boolean f5025Q = false;
    /* renamed from: R */
    private static int f5026R = -1;
    /* renamed from: a */
    public static final boolean f5027a = C1753x.m8331a();
    /* renamed from: b */
    public static String f5028b = "SAMSUNG";
    /* renamed from: c */
    public static String f5029c = "LGE";
    /* renamed from: d */
    public static String f5030d = "NEXUS 4";
    /* renamed from: e */
    public static String f5031e = "NEXUS 5";
    /* renamed from: f */
    public static int f5032f;
    /* renamed from: g */
    public static int f5033g;
    /* renamed from: h */
    public static int f5034h;
    /* renamed from: i */
    public static int f5035i;
    /* renamed from: j */
    public static double f5036j;
    /* renamed from: k */
    public static String f5037k;
    /* renamed from: l */
    public static String f5038l;
    /* renamed from: m */
    public static double f5039m;
    /* renamed from: n */
    public static double f5040n;
    /* renamed from: o */
    public static double f5041o;
    /* renamed from: p */
    public static float f5042p;
    /* renamed from: q */
    public static float f5043q;
    /* renamed from: r */
    public static long f5044r;
    /* renamed from: s */
    public static boolean f5045s;
    /* renamed from: t */
    public static float f5046t = 32.0f;
    /* renamed from: u */
    public static float f5047u = -1.0f;
    /* renamed from: v */
    public static float f5048v = 1.0f;
    /* renamed from: w */
    public static int f5049w = 30;
    /* renamed from: x */
    public static double f5050x = 32.0d;
    /* renamed from: y */
    public static double f5051y = 0.043d;
    /* renamed from: z */
    public static int f5052z = 360;

    /* renamed from: com.dermandar.a.x$a */
    static class C1752a implements FileFilter {
        C1752a() {
        }

        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* renamed from: a */
    public static boolean m8331a() {
        return VERSION.SDK_INT >= 23 && C1753x.m8339h();
    }

    /* renamed from: a */
    public static boolean m8332a(double d, double d2) {
        return Math.abs(d - d2) < 0.05d;
    }

    /* renamed from: b */
    public static int m8333b() {
        int i = 1024;
        int panoHeight = Core.getPanoHeight(f5025Q);
        if (f5025Q) {
            if (f5010B && C1753x.m8342k()) {
                i = 4096;
            } else if (f5010B || f5011C) {
                i = 2048;
            }
        } else if (f5010B) {
            i = 2048;
        } else if (!f5011C) {
            i = 512;
        }
        return Math.min(panoHeight, i);
    }

    /* renamed from: c */
    public static boolean m8334c() {
        return f5036j < 1.0d;
    }

    /* renamed from: d */
    public static int m8335d() {
        return C1753x.m8336e() > 2 ? 2 : 3;
    }

    /* renamed from: e */
    public static int m8336e() {
        int i = 1;
        if (f5026R > 0) {
            return f5026R;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C1752a());
            f5026R = listFiles.length;
            return listFiles.length;
        } catch (Exception e) {
            e.printStackTrace();
            f5026R = i;
            return i;
        }
    }

    /* renamed from: f */
    public static boolean m8337f() {
        try {
            return Build.MANUFACTURER.toUpperCase().equals(f5029c) && Build.MODEL.toUpperCase().equals(f5030d);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: g */
    public static boolean m8338g() {
        try {
            return Build.MODEL.toUpperCase().equals(f5031e);
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: h */
    public static boolean m8339h() {
        return Build.MODEL.toLowerCase().contains("nexus");
    }

    /* renamed from: i */
    public static boolean m8340i() {
        try {
            return Build.MANUFACTURER.toUpperCase().equals("HUAWEI");
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: j */
    public static boolean m8341j() {
        try {
            return Build.MANUFACTURER.toUpperCase().equals("VIVO");
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: k */
    public static boolean m8342k() {
        return C1753x.m8343l() > 2200;
    }

    /* renamed from: l */
    private static int m8343l() {
        int parseInt;
        IOException e;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
            parseInt = Integer.parseInt(randomAccessFile.readLine().replaceAll("\\D+", "")) / 1024;
            try {
                randomAccessFile.close();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return parseInt;
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            parseInt = 0;
            e = iOException;
            e.printStackTrace();
            return parseInt;
        }
        return parseInt;
    }
}
