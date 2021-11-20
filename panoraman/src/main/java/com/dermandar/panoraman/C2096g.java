package com.dermandar.panoraman;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: ir.vira.panoraman.g */
public class C2096g {
    /* renamed from: A */
    public static boolean f6245A;
    /* renamed from: B */
    public static float f6246B = 32.0f;
    /* renamed from: C */
    public static float f6247C = -1.0f;
    /* renamed from: D */
    public static float f6248D = 1.0f;
    /* renamed from: E */
    public static int f6249E = 30;
    /* renamed from: F */
    public static double f6250F = 32.0d;
    /* renamed from: G */
    public static double f6251G = 0.043d;
    /* renamed from: H */
    public static boolean f6252H = false;
    /* renamed from: I */
    public static boolean f6253I = true;
    /* renamed from: J */
    public static boolean f6254J = false;
    /* renamed from: K */
    public static boolean f6255K = true;
    /* renamed from: L */
    public static boolean f6256L = false;
    /* renamed from: M */
    public static boolean f6257M = false;
    /* renamed from: N */
    public static int f6258N = 0;
    /* renamed from: O */
    public static int f6259O = -1;
    /* renamed from: P */
    public static int f6260P = 0;
    /* renamed from: Q */
    public static int f6261Q = 0;
    /* renamed from: R */
    private static int f6262R = -1;
    /* renamed from: a */
    public static int f6263a = 0;
    /* renamed from: b */
    public static String f6264b = "CookiePrefsFileNew";
    /* renamed from: c */
    public static String f6265c = "";
    /* renamed from: d */
    public static boolean f6266d = false;
    /* renamed from: e */
    public static double f6267e = 3.4d;
    /* renamed from: f */
    public static double f6268f = f6267e;
    /* renamed from: g */
    public static String f6269g = "SAMSUNG";
    /* renamed from: h */
    public static String f6270h = "LGE";
    /* renamed from: i */
    public static String f6271i = "NEXUS 4";
    /* renamed from: j */
    public static boolean f6272j;
    /* renamed from: k */
    public static boolean f6273k;
    /* renamed from: l */
    public static boolean f6274l = false;
    /* renamed from: m */
    public static boolean f6275m = false;
    /* renamed from: n */
    public static String f6276n;
    /* renamed from: o */
    public static String f6277o;
    /* renamed from: p */
    public static String f6278p;
    /* renamed from: q */
    public static String f6279q;
    /* renamed from: r */
    public static int f6280r;
    /* renamed from: s */
    public static int f6281s;
    /* renamed from: t */
    public static int f6282t;
    /* renamed from: u */
    public static int f6283u;
    /* renamed from: v */
    public static int f6284v;
    /* renamed from: w */
    public static boolean f6285w;
    /* renamed from: x */
    public static boolean f6286x;
    /* renamed from: y */
    public static boolean f6287y;
    /* renamed from: z */
    public static boolean f6288z;

    /* renamed from: ir.vira.panoraman.g$a */
    static class C2095a implements FileFilter {
        C2095a() {
        }

        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* renamed from: a */
    public static int m9319a() {
        return f6252H ? 2500 : C2096g.m9333b() >= 2 ? 1300 : 800;
    }

    /* renamed from: a */
    public static int m9320a(int i) {
        return (int) Math.round(Math.log((double) i) / Math.log(2.0d));
    }

    /* renamed from: a */
    public static File m9321a(String str, InputStream inputStream) {
        try {
            File file = new File(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m9322a(double d) {
        double d2 = d % 1.0d;
        String valueOf = String.valueOf((int) d);
        d2 *= 60.0d;
        double d3 = d2 % 1.0d;
        int i = (int) d2;
        if (i < 0) {
            i *= -1;
        }
        String valueOf2 = String.valueOf(i);
        i = (int) (d3 * 60.0d);
        if (i < 0) {
            i *= -1;
        }
        return valueOf + "/1," + valueOf2 + "/1," + String.valueOf(i) + "/1";
    }

    /* renamed from: a */
    public static String m9323a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.applicationInfo.packageName.equalsIgnoreCase(context.getPackageName())) {
                return resolveInfo.activityInfo.name;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m9324a(Context context, Uri uri) {
        Uri uri2 = null;
        if ((VERSION.SDK_INT >= 20 ? 1 : 0) == 0 || !DocumentsContract.isDocumentUri(context, uri)) {
            return "content".equalsIgnoreCase(uri.getScheme()) ? C2096g.m9341d(uri) ? uri.getLastPathSegment() : C2096g.m9325a(context, uri, null, null) : "file".equalsIgnoreCase(uri.getScheme()) ? uri.getPath() : null;
        } else {
            String[] split;
            if (C2096g.m9330a(uri)) {
                split = DocumentsContract.getDocumentId(uri).split(":");
                return "primary".equalsIgnoreCase(split[0]) ? Environment.getExternalStorageDirectory() + "/" + split[1] : null;
            } else if (C2096g.m9336b(uri)) {
                return C2096g.m9325a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            } else if (!C2096g.m9339c(uri)) {
                return null;
            } else {
                String[] spt = DocumentsContract.getDocumentId(uri).split(":");
                Object obj = spt[0];
                if ("image".equals(obj)) {
                    uri2 = Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(obj)) {
                    uri2 = Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(obj)) {
                    uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
                }
                String str = "_id=?";
                return C2096g.m9325a(context, uri2, "_id=?", new String[]{spt[1]});
            }
        }
    }

    /* renamed from: a */
    public static String m9325a(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor = null;
        String str2 = "_data";
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str2 = query.getString(query.getColumnIndexOrThrow("_data"));
                        if (query == null) {
                            return str2;
                        }
                        query.close();
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    th2.printStackTrace();
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th3.printStackTrace();
            th = th3;
        }
        return null;
    }

    /* renamed from: a */
    public static String m9326a(String str, String str2) {
        return (str == null || str.isEmpty() || str.trim().isEmpty()) ? str2 : str;
    }

    /* renamed from: a */
    public static String m9327a(List<String> list) {
        int i = 1;
        String str = "";
        if (!(list == null || list.isEmpty())) {
            str = (String) list.get(0);
            if (list.size() > 1) {
                while (i < list.size()) {
                    String str2 = str + "," + ((String) list.get(i));
                    i++;
                    str = str2;
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static void m9328a(Context context, int i) {
        String a = C2096g.m9323a(context);
        if (a != null) {
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", i);
            intent.putExtra("badge_count_package_name", context.getPackageName());
            intent.putExtra("badge_count_class_name", a);
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: a */
    public static void m9329a(Context context, String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.e("rmh", "g: " + str);
        AssetManager assets = context.getAssets();
        if (!new File(str + "/numbers_dg.jpg").exists()) {
            try {
                C2096g.m9321a(str + "/numbers_dg.jpg", assets.open("numbers_dg.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!new File(str + "/numbers_lg.jpg").exists()) {
            try {
                C2096g.m9321a(str + "/numbers_lg.jpg", assets.open("numbers_lg.jpg"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!new File(str + "/gyrooff.jpg").exists()) {
            try {
                C2096g.m9321a(str + "/gyrooff.jpg", assets.open("gyrooff.jpg"));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (!new File(str + "/gyroon.jpg").exists()) {
            try {
                C2096g.m9321a(str + "/gyroon.jpg", assets.open("gyroon.jpg"));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (!new File(str + "/cb.raw").exists()) {
            try {
                C2096g.m9321a(str + "/cb.raw", assets.open("cb.raw"));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        if (!new File(str + "/compass-dg.raw").exists()) {
            try {
                C2096g.m9321a(str + "/compass-dg.raw", assets.open("compass-dg.raw"));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static boolean m9330a(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /* renamed from: a */
    public static boolean m9331a(String str) {
        return str.contains("iospublic") || str.contains("iospublic2") || str.contains("iosprivate") || str.contains("webpublic") || str.contains("mirrorball") || str.contains("andpublic") || str.contains("twit360");
    }

    /* renamed from: b */
    public static double m9332b(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return 0.0d;
        }
    }

    /* renamed from: b */
    public static int m9333b() {
        int i = 1;
        if (f6262R > 0) {
            return f6262R;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C2095a());
            f6262R = listFiles.length;
            return listFiles.length;
        } catch (Exception e) {
            e.printStackTrace();
            f6262R = i;
            return i;
        }
    }

    /* renamed from: b */
    public static int m9334b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    /* renamed from: b */
    public static void m9335b(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DMDPref", 0);
        int b = C2096g.m9334b(context);
        Log.e("", "Saving regId on app version " + b);
        Editor edit = sharedPreferences.edit();
        edit.putString("registration_id", str);
        edit.putInt("appVersion", b);
        edit.commit();
    }

    /* renamed from: b */
    public static boolean m9336b(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /* renamed from: c */
    public static long m9337c(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: c */
    public static String m9338c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("DMDPref", 0);
        String string = sharedPreferences.getString("registration_id", "");
        if (string.isEmpty()) {
            Log.e("", "Registration not found.");
            return "";
        } else if (sharedPreferences.getInt("appVersion", Integer.MIN_VALUE) == C2096g.m9334b(context)) {
            return string;
        } else {
            Log.e("", "App version changed.");
            return "";
        }
    }

    /* renamed from: c */
    public static boolean m9339c(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* renamed from: d */
    public static List<String> m9340d(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null || str.isEmpty()) {
            return arrayList;
        }
        String[] split = str.trim().split(",");
        for (String trim : split) {
            String trim2 = trim.trim();
            if (!trim2.isEmpty()) {
                arrayList.add(trim2);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static boolean m9341d(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}
