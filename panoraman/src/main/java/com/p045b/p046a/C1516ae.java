package com.p045b.p046a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.System;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.b.a.ae */
final class C1516ae {
    /* renamed from: a */
    static final StringBuilder f4139a = new StringBuilder();

    @TargetApi(11)
    /* renamed from: com.b.a.ae$a */
    private static class C1511a {
        /* renamed from: a */
        static int m7377a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    @TargetApi(12)
    /* renamed from: com.b.a.ae$b */
    private static class C1512b {
        /* renamed from: a */
        static int m7378a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    /* renamed from: com.b.a.ae$c */
    private static class C1513c {
        /* renamed from: a */
        static C1506j m7379a(Context context) {
            return new C1549s(context);
        }
    }

    /* renamed from: com.b.a.ae$d */
    private static class C1514d extends Thread {
        public C1514d(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* renamed from: com.b.a.ae$e */
    static class C1515e implements ThreadFactory {
        C1515e() {
        }

        public Thread newThread(Runnable runnable) {
            return new C1514d(runnable);
        }
    }

    /* renamed from: a */
    static int m7380a(Resources resources, C1565w c1565w) throws FileNotFoundException {
        if (c1565w.f4304e != 0 || c1565w.f4303d == null) {
            return c1565w.f4304e;
        }
        String authority = c1565w.f4303d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c1565w.f4303d);
        }
        List pathSegments = c1565w.f4303d.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + c1565w.f4303d);
        } else if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt((String) pathSegments.get(0));
            } catch (NumberFormatException e) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + c1565w.f4303d);
            }
        } else if (pathSegments.size() == 2) {
            return resources.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
        } else {
            throw new FileNotFoundException("More than two path segments: " + c1565w.f4303d);
        }
    }

    /* renamed from: a */
    static int m7381a(Bitmap bitmap) {
        int a = VERSION.SDK_INT >= 12 ? C1512b.m7378a(bitmap) : bitmap.getRowBytes() * bitmap.getHeight();
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    /* renamed from: a */
    static long m7382a(File file) {
        long blockSize;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockSize = (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 50;
        } catch (IllegalArgumentException e) {
            blockSize = 5242880;
        }
        return Math.max(Math.min(blockSize, 52428800), 5242880);
    }

    /* renamed from: a */
    static Resources m7383a(Context context, C1565w c1565w) throws FileNotFoundException {
        if (c1565w.f4304e != 0 || c1565w.f4303d == null) {
            return context.getResources();
        }
        String authority = c1565w.f4303d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c1565w.f4303d);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (NameNotFoundException e) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + c1565w.f4303d);
        }
    }

    /* renamed from: a */
    static C1506j m7384a(Context context) {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return C1513c.m7379a(context);
        } catch (ClassNotFoundException e) {
            return new C1509ad(context);
        }
    }

    /* renamed from: a */
    static <T> T m7385a(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    /* renamed from: a */
    static <T> T m7386a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    static String m7387a(C1526c c1526c) {
        return C1516ae.m7388a(c1526c, "");
    }

    /* renamed from: a */
    static String m7388a(C1526c c1526c, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        C1498a i = c1526c.mo5710i();
        if (i != null) {
            stringBuilder.append(i.f4087b.mo5790a());
        }
        List k = c1526c.mo5712k();
        if (k != null) {
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0 || i != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((C1498a) k.get(i2)).f4087b.mo5790a());
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    static String m7389a(C1565w c1565w) {
        String a = C1516ae.m7390a(c1565w, f4139a);
        f4139a.setLength(0);
        return a;
    }

    /* renamed from: a */
    static String m7390a(C1565w c1565w, StringBuilder stringBuilder) {
        if (c1565w.f4305f != null) {
            stringBuilder.ensureCapacity(c1565w.f4305f.length() + 50);
            stringBuilder.append(c1565w.f4305f);
        } else if (c1565w.f4303d != null) {
            String uri = c1565w.f4303d.toString();
            stringBuilder.ensureCapacity(uri.length() + 50);
            stringBuilder.append(uri);
        } else {
            stringBuilder.ensureCapacity(50);
            stringBuilder.append(c1565w.f4304e);
        }
        stringBuilder.append(10);
        if (c1565w.f4312m != 0.0f) {
            stringBuilder.append("rotation:").append(c1565w.f4312m);
            if (c1565w.f4315p) {
                stringBuilder.append('@').append(c1565w.f4313n).append('x').append(c1565w.f4314o);
            }
            stringBuilder.append(10);
        }
        if (c1565w.mo5793d()) {
            stringBuilder.append("resize:").append(c1565w.f4307h).append('x').append(c1565w.f4308i);
            stringBuilder.append(10);
        }
        if (c1565w.f4309j) {
            stringBuilder.append("centerCrop").append(10);
        } else if (c1565w.f4310k) {
            stringBuilder.append("centerInside").append(10);
        }
        if (c1565w.f4306g != null) {
            int size = c1565w.f4306g.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(((C1503ac) c1565w.f4306g.get(i)).mo5673a());
                stringBuilder.append(10);
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    static void m7391a() {
        if (!C1516ae.m7398b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    /* renamed from: a */
    static void m7392a(Looper looper) {
        Handler c15101 = new Handler(looper) {
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        c15101.sendMessageDelayed(c15101.obtainMessage(), 1000);
    }

    /* renamed from: a */
    static void m7393a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    static void m7394a(String str, String str2, String str3) {
        C1516ae.m7395a(str, str2, str3, "");
    }

    /* renamed from: a */
    static void m7395a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    /* renamed from: a */
    static boolean m7396a(String str) {
        boolean z = true;
        if (str == null) {
            return false;
        }
        String[] split = str.split(" ", 2);
        if ("CACHE".equals(split[0])) {
            return true;
        }
        if (split.length == 1) {
            return false;
        }
        try {
            if (!("CONDITIONAL_CACHE".equals(split[0]) && Integer.parseInt(split[1]) == 304)) {
                z = false;
            }
            return z;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* renamed from: b */
    static File m7397b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: b */
    static boolean m7398b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: b */
    static boolean m7399b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: b */
    static byte[] m7400b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: c */
    static int m7401c(Context context) {
        ActivityManager activityManager = (ActivityManager) C1516ae.m7385a(context, "activity");
        int memoryClass = (((context.getApplicationInfo().flags & 1048576) != 0 ? 1 : null) == null || VERSION.SDK_INT < 11) ? activityManager.getMemoryClass() : C1511a.m7377a(activityManager);
        return (memoryClass * 1048576) / 7;
    }

    /* renamed from: c */
    static boolean m7402c(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    /* renamed from: d */
    static boolean m7403d(Context context) {
        try {
            return System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
